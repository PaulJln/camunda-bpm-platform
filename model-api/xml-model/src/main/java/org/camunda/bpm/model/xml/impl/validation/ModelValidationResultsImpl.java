/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.model.xml.impl.validation;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.camunda.bpm.model.xml.instance.DomElement;
import org.camunda.bpm.model.xml.instance.ModelElementInstance;
import org.camunda.bpm.model.xml.type.ModelElementType;
import org.camunda.bpm.model.xml.validation.ValidationResultFormatter;
import org.camunda.bpm.model.xml.validation.ValidationResult;
import org.camunda.bpm.model.xml.validation.ValidationResults;

/**
 * @author Daniel Meyer
 *
 */
public class ModelValidationResultsImpl implements ValidationResults {

  protected Map<ModelElementInstance, List<ValidationResult>> collectedResults;

  protected int errorCount;
  protected int warningCount;

  public ModelValidationResultsImpl(Map<ModelElementInstance, List<ValidationResult>> collectedResults, int errorCount, int warningCount) {
    this.collectedResults = collectedResults;
    this.errorCount = errorCount;
    this.warningCount = warningCount;
  }

  @Override
  public boolean hasErrors() {
    return errorCount > 0;
  }

  @Override
  public int getErrorCount() {
    return errorCount;
  }

  @Override
  public int getWarinigCount() {
    return warningCount;
  }

  @Override
  public void write(StringWriter writer, ValidationResultFormatter formatter) {
    for (Entry<ModelElementInstance, List<ValidationResult>> entry : collectedResults.entrySet()) {

      ModelElementInstance element = entry.getKey();
      List<ValidationResult> results = entry.getValue();

      formatter.formatElement(writer, element);

      for (ValidationResult result : results) {
        formatter.formatResult(writer, result);
      }
    }
  }

  @Override
  public Map<ModelElementInstance, List<ValidationResult>> getResults() {
    return collectedResults;
  }

}
