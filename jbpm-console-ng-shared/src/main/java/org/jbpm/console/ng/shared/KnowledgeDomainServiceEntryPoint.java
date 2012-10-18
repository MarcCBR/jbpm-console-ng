/*
 * Copyright 2012 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jbpm.console.ng.shared;

import java.util.Collection;
import java.util.Map;
import org.jboss.errai.bus.server.annotations.Remote;
import org.jbpm.console.ng.client.model.NodeInstanceSummary;
import org.jbpm.console.ng.client.model.ProcessInstanceSummary;
import org.jbpm.console.ng.client.model.ProcessSummary;
import org.jbpm.console.ng.client.model.StatefulKnowledgeSessionSummary;
import org.jbpm.console.ng.client.model.TaskDefSummary;

/**
 *
 * @author salaboy
 */
@Remote
public interface KnowledgeDomainServiceEntryPoint {
    
    StatefulKnowledgeSessionSummary getSession(long sessionId);
    
    StatefulKnowledgeSessionSummary getSessionSummaryByBusinessKey(String businessKey);
    
    Collection<String> getSessionsNames();
    
    int getAmountOfSessions();
    
    Collection<ProcessInstanceSummary> getProcessInstances();

    Collection<ProcessInstanceSummary> getProcessInstancesBySessionId(String sessionId);
    
    Collection<ProcessSummary> getProcessesBySessionId(String sessionId);
    
    Collection<ProcessSummary> getProcesses();
    
    Collection<TaskDefSummary> getAllTasksDef(String bpmn2Content);
    
    Map<String, String> getAvailableProcesses();
    
    Map<String, String> getRequiredInputData(String bpmn2Content);
    
    Map<String, String> getAssociatedEntities(String bpmn2Content);
    
    Collection<NodeInstanceSummary> getProcessInstanceHistory(int sessionId, long id); 
    
    Collection<NodeInstanceSummary> getProcessInstanceHistory(int sessionId, long processId, boolean completed);

    Collection<NodeInstanceSummary> getProcessInstanceFullHistory(int sessionId, long processId);

    Collection<NodeInstanceSummary> getProcessInstanceActiveNodes(int sessionId, long processId);
    
}