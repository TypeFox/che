/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.che.plugin.languageserver.shared.lsapi;

import io.typefox.lsapi.CodeActionParams;
import org.eclipse.che.dto.shared.DTO;
import org.eclipse.che.plugin.languageserver.shared.lsapi.CodeActionContextDTO;
import org.eclipse.che.plugin.languageserver.shared.lsapi.RangeDTO;
import org.eclipse.che.plugin.languageserver.shared.lsapi.TextDocumentIdentifierDTO;

@DTO
@SuppressWarnings("all")
public interface CodeActionParamsDTO extends CodeActionParams {
  /**
   * Overridden to return the DTO type.
   * 
   */
  public abstract TextDocumentIdentifierDTO getTextDocument();
  
  /**
   * Overridden to return the DTO type.
   * 
   */
  public abstract RangeDTO getRange();
  
  /**
   * Overridden to return the DTO type.
   * 
   */
  public abstract CodeActionContextDTO getContext();
}
