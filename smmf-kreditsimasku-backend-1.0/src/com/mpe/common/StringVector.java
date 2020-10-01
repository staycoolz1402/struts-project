package com.mpe.common;

public class StringVector extends java.util.Vector {
    
    /** Creates a new instance of StringVector */
    public StringVector() {
        super();
    }
    
    public StringVector(String str, char separator){
        super();
        StringBuffer temp = new StringBuffer(50);
        char c;
        for (int i=0; i < str.length(); i++){
            if ( (c = str.charAt(i)) != separator){
                temp.append(c);
            }
            else {
                this.addElement((String)temp.toString());
                temp = new StringBuffer(50);
            }
        }
        this.addElement(temp.toString());
    }
    
    public String stringElementAt(int i ){
        return (String)elementAt(i);
    }
    
    public int intElementAt(int i){
        try{
            return Integer.parseInt(stringElementAt(i));
        }
        catch(Exception e){
            return 0;
        }
    }
    
    public long longElementAt(int i){
        try{
            return Long.parseLong(stringElementAt(i));
        }
        catch(Exception e){
            return 0;
        }
    }

    
}

