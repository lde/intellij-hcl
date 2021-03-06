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
package org.intellij.plugins.hcl;

import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.fileEditor.impl.LoadTextUtil;
import com.intellij.testFramework.LightVirtualFile;
import com.intellij.testFramework.ParsingTestCase;
import com.intellij.testFramework.TestDataPath;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

@TestDataPath("$CONTENT_ROOT/test-data/psi/")
public class HCLParserTest extends ParsingTestCase {
  protected HCLParserTest(@NonNls @NotNull String dataPath, @NotNull String fileExt, final boolean lowercaseFirstLetter, @NotNull ParserDefinition... definitions) {
    super(dataPath, fileExt, lowercaseFirstLetter, definitions);
  }

  public HCLParserTest() {
    this("psi", "hcl", false, new HCLParserDefinition());
  }

  @Override
  protected String getTestDataPath() {
    return "test-data/";
  }

  protected void doTest() {
    doTest(true);
  }


  public void testEmpty() throws Exception {
    doTest();
  }

  public void testComment_Single() throws Exception {
    doTest();
  }

  public void testComment_Multiline() throws Exception {
    doTest();
  }

  public void testComment_Complex() throws Exception {
    doTest();
  }

  public void testSimple_Types() throws Exception {
    doTest();
  }

  public void testList_Simple() throws Exception {
    doTest();
  }

  public void testList_Tailing_Comma() throws Exception {
    doTest();
  }

  public void testMultiple_Properties() throws Exception {
    doTest();
  }

  public void testHereDoc() throws Exception {
    doTest();
  }
  public void testHereDoc_Empty() throws Exception {
    doTest();
  }

  public void testHereDoc_EmptyLines() throws Exception {
    doTest();
  }

  public void testHereDoc_Incomplete() throws Exception {
    doTest();
  }

  public void testHereDoc_Missing_Marker() throws Exception {
    doTest();
  }

  public void testHereDoc_Indented() throws Exception {
    doTest();
  }

  public void testHereDoc_Indented_End() throws Exception {
    doTest();
  }

  public void testIdentifiers() throws Exception {
    doTest();
  }

  public void testBlock_Empty() throws Exception {
    doTest();
  }

  public void testBlock() throws Exception {
    doTest();
  }

  public void testComplex() throws Exception {
    doTest();
  }

  public void testArrayTailComment() throws Exception {
    doTest();
  }

  public void testIncomplete_Block() throws Exception {
    doTest();
  }

  public void testIncomplete_Property_Or_Block() throws Exception {
    doTest();
  }

  public void testExtraQuote() throws Exception {
    doTest();
  }

  public void testExtraQuoteNoNewLine() throws Exception {
    doTest();
  }

  public void testIAM_Role_Policy() throws Exception {
    doTest();
  }

  public void testAssign_Deep() throws Exception {
    doTest();
  }

  public void testList_Of_Maps() throws Exception {
    doTest();
  }

  public void testList_Of_Lists() throws Exception {
    doTest();
  }

  public void testObject_List_Comma() throws Exception {
    doTest();
  }

  public void testMultiline_Literal() throws Exception {
    doTest();
  }

  public void testList_With_Identifier() throws Exception {
    doTest();
  }

  public void testUnfinished_String() throws Exception {
    doTest();
  }

  public void testUnfinished_Block_Name() throws Exception {
    doTest();
  }

  // From several 'panic' issues in HCL itself
  public void testBrokenInput() throws Exception {
    doTestNoException("{\"\\0"); // #194
    doTestNoException("wÔΩø\u00dc<<070005000\n"); // #130
    doTestNoException("t\"\\400n\"{}"); // #129
    doTestNoException("{:{"); // #128
    doTestNoException("\"\\0"); // #127
  }

  private void doTestNoException(String text) {
    myFile = createPsiFile("a", text);
    ensureParsed(myFile);
    assertEquals("light virtual file text mismatch", text, ((LightVirtualFile) myFile.getVirtualFile()).getContent().toString());
    assertEquals("virtual file text mismatch", text, LoadTextUtil.loadText(myFile.getVirtualFile()));
    assertEquals("doc text mismatch", text, myFile.getViewProvider().getDocument().getText());
    assertEquals("psi text mismatch", text, myFile.getText());
    toParseTreeText(myFile, skipSpaces(), includeRanges());
  }
}
