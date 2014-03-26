/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.feu.eac;

import org.apache.lucene.demo.IndexFiles;

/**
 *
 * @author Simaco.Menzon
 */
public class Train {
    
    public void createIndex() {
        String[] indexString = {"-docs", "./corpus", "-index", "./index"};
        IndexFiles.main(indexString);
    }
}
