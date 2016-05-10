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
package org.eclipse.che.api.debugger.shared.dto.event;

import org.eclipse.che.api.debugger.shared.model.event.DebuggerEvent;
import org.eclipse.che.dto.shared.DTO;

/**
 * @author Anatoliy Bazko
 */
@DTO
public interface DisconnectEventDto extends DebuggerEventDto {
    DebuggerEvent.TYPE getType();

    void setType(DebuggerEvent.TYPE type);

    DisconnectEventDto withType(DebuggerEvent.TYPE type);
}
