/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.pubsubhubbub;

import org.apache.commons.lang.StringUtils;

public enum HubMode
{
    SUBSCRIBE, UNSUBSCRIBE, PUBLISH;

    public String getMode()
    {
        return StringUtils.lowerCase(this.toString());
    }

    public static HubMode parse(final String s)
    {
        try
        {
            return valueOf(StringUtils.upperCase(s));
        }
        catch (final IllegalArgumentException iae)
        {
            // rethrow with a less technical message, as it is routed back to the caller
            throw new IllegalArgumentException("Unsupported hub mode: " + s, iae);
        }
    }
}
