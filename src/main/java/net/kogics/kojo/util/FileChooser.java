/*
 * Copyright (C) 2011 Lalit Pant <pant.lalit@gmail.com>
 *
 * The contents of this file are subject to the GNU General Public License
 * Version 3 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.gnu.org/copyleft/gpl.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 */
package net.kogics.kojo.util;

import net.kogics.kojo.core.KojoCtx;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public final class FileChooser {
    KojoCtx ctx;

    public FileChooser(KojoCtx ctx) {
        this.ctx = ctx;
    }

    public File chooseFile(String title, String desc, String... ext) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(desc, ext);
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setDialogTitle(title);

        String loadDir = ctx.getLastLoadStoreDir();
        if (loadDir != null && loadDir != "") {
            File dir = new File(loadDir);
            if (dir.exists() && dir.isDirectory()) {
                chooser.setCurrentDirectory(dir);
            }
        }

        int returnVal = chooser.showSaveDialog(ctx.frame());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            ctx.setLastLoadStoreDir(chooser.getSelectedFile().getParent());
            File selectedFile = chooser.getSelectedFile();
            if (!selectedFile.getName().contains(".")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + "."
                        + ext[0]);
            }
            return selectedFile;
        }
        else {
            return null;
        }
    }

}
