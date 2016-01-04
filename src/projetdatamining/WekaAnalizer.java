/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetdatamining;

import java.io.IOException;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.core.converters.JSONLoader;

/**
 *
 * @author Benjamin Chamfort
 */
public final class WekaAnalizer 
{
    ///Données du json chargées
    private JSONLoader Data;

    ///getter de données
    public JSONLoader getData() {
        return Data;
    }
    //Setter des données du jSOn
    public void setData(JSONLoader data) {
        this.Data = data;
    }
    //Constructeur
    public WekaAnalizer(JSONLoader data)
    {
        setData(data);
    }
    
    //Analyseur de données
    public void AnalyzeData() throws IOException, Exception{
        Instances data = getData().getDataSet();
        String[] options = new String[2];
        options[0] = "-R";                                  // "range"
        options[1] = "1";                                   // first attribute
        Remove remove = new Remove();                       // new instance of filter
        remove.setOptions(options);                         // set options
        remove.setInputFormat(data);                        // inform filter about dataset **AFTER** setting options
        Instances newData = Filter.useFilter(data, remove);   // apply filter
    }
    
    //Méthode de test des données
    public void TestData()
    {
    }
}
