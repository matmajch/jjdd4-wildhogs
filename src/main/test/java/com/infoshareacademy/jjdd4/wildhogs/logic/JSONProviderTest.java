package com.infoshareacademy.jjdd4.wildhogs.logic;

import com.infoshareacademy.jjdd4.wildhogs.app.Configuration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ConcurrentNavigableMap;

import static com.infoshareacademy.jjdd4.wildhogs.app.Configuration.CONFIG_PATH;
import static org.assertj.core.api.Assertions.assertThat;

class JSONProviderTest {


    @Test
    void readsDefaultRecipes() {
        JSONProvider json = new JSONProvider();
        Configuration configuration = new Configuration();
        JSONObject jsonObject = json.read( configuration );

        assertThat( jsonObject ).isNotNull();
        assertThat( jsonObject.get( "recipes" ) ).isNotNull().isInstanceOf( JSONArray.class );
    }

    @Test
    void ReturnEmptyObject() {
        Properties properties = new Properties();
        properties.setProperty( "jsonPath", "invalid_file" );

        Configuration configuration = new Configuration( properties );
        JSONProvider json = new JSONProvider();

        JSONObject jsonObject = json.read( configuration );

        assertThat( jsonObject ).isNotNull();
        assertThat( jsonObject.isEmpty() ).isTrue();

    }
}