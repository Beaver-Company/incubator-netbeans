/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2009 Sun Microsystems, Inc.
 */
package org.netbeans.test.subversion;

import junit.framework.Test;
import org.netbeans.jellytools.JellyTestCase;
import org.netbeans.test.subversion.main.archeology.AnnotationsTest;
import org.netbeans.test.subversion.main.archeology.SearchHistoryUITest;
import org.netbeans.test.subversion.main.archeology.SearchRevisionsTest;
import org.netbeans.test.subversion.main.branches.*;
import org.netbeans.test.subversion.main.checkout.*;
import org.netbeans.test.subversion.main.commit.CommitDataTest;
import org.netbeans.test.subversion.main.commit.CommitUiTest;
import org.netbeans.test.subversion.main.commit.IgnoreTest;
import org.netbeans.test.subversion.main.delete.DeleteTest;
import org.netbeans.test.subversion.main.delete.FilesViewDoubleRefTest;
import org.netbeans.test.subversion.main.delete.FilesViewRefTest;
import org.netbeans.test.subversion.main.delete.RefactoringTest;
import org.netbeans.test.subversion.main.diff.DiffTest;
import org.netbeans.test.subversion.main.diff.ExportDiffPatchTest;
import org.netbeans.test.subversion.main.properties.SvnPropertiesTest;
import org.netbeans.test.subversion.main.relocate.RelocateTest;

/**
 *
 */
public class SubversionStableTest extends JellyTestCase {

    public SubversionStableTest(String name) {
        super(name);
    }

    public static Test suite() {
        return emptyConfiguration()
                .addTest(CheckoutContentTest.class, "testCheckoutProject", "testCheckoutContent")
                .addTest(CheckoutUITest.class, "testInvokeClose", "testChangeAccessTypes", "testIncorrentUrl", "testAvailableFields", "testRepositoryFolder")
                .addTest(CreateProjectVersionedDirTest.class, "testCreateNewProject")
                .addTest(ImportUITest.class, "testInvoke", "testWarningMessage", "testCommitStep")
                .addTest(ProxySettingsUITest.class, "testProxySettings", "testProxyBeforeUrl")
                .addTest(CommitDataTest.class, "testCommitFile", "testCommitPackage", "testRecognizeMimeType")
                .addTest(CommitUiTest.class, "testInvokeCloseCommit")
                .addTest(IgnoreTest.class, "testIgnoreUnignoreFile", "testIgnoreUnignorePackage", "testIgnoreUnignoreFilePackage", "testFinalRemove")
                //.addTest(DeleteTest.class, "testDeleteRevert", "testDeleteCommit")
                //.addTest(FilesViewDoubleRefTest.class, "testFilesViewDoubleRefactoring")
                //.addTest(FilesViewRefTest.class, "testFilesViewRefactoring")
                //.addTest(RefactoringTest.class, "testRefactoring")
                .addTest(DiffTest.class, "testDiffFile")
                .addTest(ExportDiffPatchTest.class, "invokeExportDiffPatch")
                .addTest(AnnotationsTest.class, "testShowAnnotations")
                .addTest(SearchRevisionsTest.class, "testSearchRevisionsTest")
                .addTest(SearchHistoryUITest.class, "testInvokeSearch")
                .addTest(CopyTest.class, "testCreateNewCopySwitch", "testCreateNewCopy")
                .addTest(CopyUiTest.class, "testInvokeCloseCopy")
                .addTest(MergeUiTest.class, "testInvokeCloseMerge")
                .addTest(RevertUiTest.class, "testInvokeCloseRevert")
                .addTest(SwitchUiTest.class, "testInvokeCloseSwitch")
                .addTest(SvnPropertiesTest.class, "propTest")
                .addTest(RelocateTest.class, "relocate")
                .suite();
    }
}