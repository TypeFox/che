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
package org.eclipse.che.api.debugger.shared.model;

/**
 * @author Anatoliy Bazko
 */
public interface Breakpoint {
    /**
     * The location of the breakpoint.
     */
    Location getLocation();

    /**
     * Indicates if it is enabled or not.
     */
    boolean isEnabled();

    /**
     * The condition.
     */
    String getCondition();
}
