/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.synapse.mediators.xquery;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.synapse.mediators.MediatorTestCase;
import org.apache.synapse.mediators.clients.AxisOperationClient;

import javax.xml.namespace.QName;

/**
 * Test case for XQuery transformation with target attribute specified as XPath value and variable as Double
 */
public class XQueryCustomVariableAsDoubleTestCase extends MediatorTestCase {

    public XQueryCustomVariableAsDoubleTestCase() {
        loadConfiguration("/mediators/xqueryCustomVariableDoubleTestConfig.xml");
    }

    public void testXQueryTransformationDouble() throws AxisFault {
        AxisOperationClient client = getAxisOperationClient();
        OMElement response = client.sendCustomPayload("http://localhost:8280/services/xQueryCustomVariableAsDoubleTestProxy",
                null, "WSO2", "urn:getQuote");
        assertNotNull("Response is null", response);
        assertEquals("Symbol name mismatched", String.valueOf(156312766322.985675),
                response.getFirstElement().getFirstElement().getFirstElement().getFirstChildWithName(new QName(
                        "http://services.samples/xsd", "symbol")).getText());
    }
}
