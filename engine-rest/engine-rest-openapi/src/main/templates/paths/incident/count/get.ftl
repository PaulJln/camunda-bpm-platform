{

  <@lib.endpointInfo
      id = "getIncidentsCount"
      tag = "Incident"
      summary = "Get List Count"
      desc = "Queries for the number of incidents that fulfill given parameters. Takes the same parameters as the
      [Get Incidents](${docsUrl}/reference/rest/incident/get-query/) method." />

  "parameters": [
    <#assign last = true >
    <#include "/lib/commons/incident-query-params.ftl">
  ],
  "responses" : {

    <@lib.response
        code = "200"
        dto = "CountResultDto"
        array = true
        desc = "Request successful."
        examples = ['"example-1": {
                       "summary": "GET `/incident?processInstanceId=aProcInstId`",
                       "value": [
                           {
                             "id": "anIncidentId",
                             "processDefinitionId": "aProcDefId",
                             "processInstanceId": "aProcInstId",
                             "executionId": "anExecutionId",
                             "incidentTimestamp": "2014-03-01T08:00:00.000+0200",
                             "incidentType": "failedJob",
                             "activityId": "serviceTask",
                             "failedActivityId": "serviceTask",
                             "causeIncidentId": "aCauseIncidentId",
                             "rootCauseIncidentId": "aRootCauseIncidentId",
                             "configuration": "aConfiguration",
                             "tenantId": null,
                             "incidentMessage": "anIncidentMessage",
                             "jobDefinitionId": "aJobDefinitionId"
                           },
                           {
                             "id": "anIncidentId",
                             "processDefinitionId": "aProcDefId",
                             "processInstanceId": "aProcInstId",
                             "executionId": "anotherExecutionId",
                             "incidentTimestamp": "2014-03-01T09:00:00.000+0200",
                             "incidentType": "customIncidentType",
                             "activityId": "userTask",
                             "failedActivityId": "userTask",
                             "causeIncidentId": "anotherCauseIncidentId",
                             "rootCauseIncidentId": "anotherRootCauseIncidentId",
                             "configuration": "anotherConfiguration",
                             "tenantId": null,
                             "incidentMessage": "anotherIncidentMessage",
                             "jobDefinitionId": null
                           }
                         ]
                     }'] />

    <@lib.response
        code = "400"
        dto = "ExceptionDto"
        last = true
        desc = "Returned if some of the query parameters are invalid. See the [Introduction](${docsUrl}/reference/rest/overview/#error-handling) for the error
                response format." />
    }
}
