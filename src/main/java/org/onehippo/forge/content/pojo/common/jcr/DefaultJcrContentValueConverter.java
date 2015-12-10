/*
 *  Copyright 2015-2015 Hippo B.V. (http://www.onehippo.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.onehippo.forge.content.pojo.common.jcr;

import javax.jcr.PropertyType;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;

import org.apache.jackrabbit.util.ISO8601;
import org.onehippo.forge.content.pojo.common.ContentNodeException;
import org.onehippo.forge.content.pojo.common.ContentValueConverter;

public class DefaultJcrContentValueConverter implements ContentValueConverter<Value> {

    private Session session;

    public DefaultJcrContentValueConverter(final Session session) {
        this.session = session;
    }

    @Override
    public String toString(Value value) throws ContentNodeException {
        try {
            String stringifiedValue = null;

            switch (value.getType()) {
            case PropertyType.STRING: {
                stringifiedValue = value.getString();
                break;
            }
            case PropertyType.BINARY: {
                stringifiedValue = binaryValueToString(value);
                break;
            }
            case PropertyType.LONG: {
                stringifiedValue = Long.toString(value.getLong());
                break;
            }
            case PropertyType.DOUBLE: {
                stringifiedValue = Double.toString(value.getDouble());
                break;
            }
            case PropertyType.DATE: {
                stringifiedValue = ISO8601.format(value.getDate());
                break;
            }
            case PropertyType.BOOLEAN: {
                stringifiedValue = Boolean.toString(value.getBoolean());
                break;
            }
            case PropertyType.DECIMAL: {
                stringifiedValue = value.getDecimal().toString();
                break;
            }
            case PropertyType.NAME:
            case PropertyType.PATH:
            case PropertyType.URI: {
                stringifiedValue = value.getString();
                break;
            }
            case PropertyType.REFERENCE: {
                stringifiedValue = referenceValueToString(value);
                break;
            }
            case PropertyType.WEAKREFERENCE: {
                stringifiedValue = weakReferenceValueToString(value);
                break;
            }
            }

            return stringifiedValue;
        } catch (RepositoryException e) {
            throw new ContentNodeException(e.toString(), e);
        }
    }

    @Override
    public Value toValue(String stringValue) throws ContentNodeException {
        return null;
    }

    protected Session getSession() {
        return session;
    }

    protected String binaryValueToString(final Value value) {
        return null;
    }

    protected String referenceValueToString(final Value value) {
        return null;
    }

    protected String weakReferenceValueToString(final Value value) {
        return null;
    }
}
