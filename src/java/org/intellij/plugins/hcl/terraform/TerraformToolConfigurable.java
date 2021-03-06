/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.intellij.plugins.hcl.terraform;

import com.intellij.openapi.options.ConfigurableBase;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class TerraformToolConfigurable extends ConfigurableBase<TerraformSettingsPanel, TerraformToolProjectSettings> {
  private final Project myProject;

  public TerraformToolConfigurable(Project project) {
    super("reference.settingsdialog.project.terraform", "Terraform", null);
    myProject = project;
  }

  @NotNull
  @Override
  protected TerraformToolProjectSettings getSettings() {
    return TerraformToolProjectSettings.getInstance(myProject);
  }

  @Override
  protected TerraformSettingsPanel createUi() {
    return new TerraformSettingsPanel();
  }
}
