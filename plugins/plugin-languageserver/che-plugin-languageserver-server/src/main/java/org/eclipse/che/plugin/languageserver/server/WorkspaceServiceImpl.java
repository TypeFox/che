/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.plugin.languageserver.server;

import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.services.LanguageServer;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.plugin.languageserver.shared.lsapi.WorkspaceSymbolParamsDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.util.Collections.emptyList;

/**
 * REST API for the workspace/* services defined in https://github.com/Microsoft/vscode-languageserver-protocol
 * Dispatches onto the {@link LanguageServerRegistry}.
 *
 * @author Evgen Vidolob
 */
@Singleton
@Path("languageserver/workspace")
public class WorkspaceServiceImpl {
    private LanguageServerRegistry languageServerRegistry;

    @Inject
    public WorkspaceServiceImpl(LanguageServerRegistry languageServerRegistry) {
        this.languageServerRegistry = languageServerRegistry;
    }

    @POST
    @Path("symbol")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<? extends SymbolInformation> documentSymbol(WorkspaceSymbolParamsDTO workspaceSymbolParams)
            throws ExecutionException, InterruptedException {
        LanguageServer server = getServer(workspaceSymbolParams.getFileUri());
        if (server == null) {
            return emptyList();
        }

        return server.getWorkspaceService().symbol(workspaceSymbolParams).get();
    }

    private LanguageServer getServer(String uri) {
        return languageServerRegistry.findServer(uri);
    }
}
