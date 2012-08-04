package com.procrastination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Defaults implements Serializable {/*defaults this options could be configured per component*/
    /*rethink this abstraction*/
    private boolean autolinks = true;
    private String classname = null;
    private boolean collapse = false;
    private int firstLine = -1;
    private boolean gutter = true;
    private List<Integer> highlight = new ArrayList<Integer>();
    private boolean htmlScript = false;
    private boolean smartTabs = true;
    private int tabSize = 4;
    private boolean toolbar = false;

    public Defaults() {
    }
}