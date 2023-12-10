package com.Automate.utilitas;

import java.io.File;

public class schema {
    public static File mendapatkanFILEJSON_schemaAPI(String file){
        File postSchema = new File("");
        if (file.equals("Post.json")){
            return new File("src/test/resources/Schema/Post/", file);
        } else if (file.equals("GET_All.json")) {
            return new File("src/test/resources/Schema/Get/", file);
        } else if (file.equals("GET_Single.json")) {
            return new File("src/test/resources/Schema/Get/", file);
        } else if (file.equals("GET_Tag.json")) {
            return new File("src/test/resources/Schema/Get/", file);
        } else if (file.equals("Update_user.json")) {
            return new File("src/test/resources/Schema/Update/", file);
        }
        else if (file.equals("Delete_userError.json")) {
            return new File("src/test/resources/Schema/Delete/", file);
        } else {
            System.out.println("Masukan file schema");
        }
        return postSchema;
    }

    //return new File("src/test/resources/Schema", file);
}
