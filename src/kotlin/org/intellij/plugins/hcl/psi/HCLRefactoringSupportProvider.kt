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
package org.intellij.plugins.hcl.psi

import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.refactoring.RefactoringActionHandler
import org.intellij.plugins.hcl.terraform.config.refactoring.TerraformIntroduceVariableHandler

class HCLRefactoringSupportProvider : RefactoringSupportProvider() {
  override fun isAvailable(context: PsiElement): Boolean {
    return context is HCLElement && context is PsiNamedElement
  }

  // Inplace refactoring supported only if element#getUseScope is instance of LocalSearchScope
  override fun isInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
    return element is HCLElement && element is PsiNamedElement
  }

  override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
    return element is HCLElement && element is PsiNamedElement
  }

  override fun getIntroduceVariableHandler(): RefactoringActionHandler? {
    return TerraformIntroduceVariableHandler()
  }

  override fun getIntroduceVariableHandler(element: PsiElement?): RefactoringActionHandler? {
    return TerraformIntroduceVariableHandler()
  }
}