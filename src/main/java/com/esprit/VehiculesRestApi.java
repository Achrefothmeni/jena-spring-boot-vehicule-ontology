package com.esprit;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

 

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.jena.ontology.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class VehiculesRestApi {
    List<JSONObject> listVehicules=new ArrayList();
    OntModel model = null;
    public OntModel readModel() {
    	String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
           
            return model;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/moyennegame",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getMoyenneGames() {
    	
		   
        List<JSONObject> list=new ArrayList();
        String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String querygetPays =
   	    	     "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
   	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
   	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +

   	    	     " SELECT ?MoyenneGamme ?nom " +
   	    	     " WHERE { ?MoyenneGamme vec:nom ?nom    } " ;
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("id",x);
                System.out.println(solution);
              
                System.out.println(solution.get("nom").toString().substring(solution.get("nom").toString().indexOf('#')+1));
                obj.put("label",solution.get("MoyenneGamme").toString().substring(solution.get("MoyenneGamme").toString().indexOf('#')+1));
               obj.put("nom",solution.get("nom").toString().substring(solution.get("nom").toString().indexOf('#')+1));
        
          
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @RequestMapping(value = "/hautegame",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getHauteGames() {
    	
		   
        List<JSONObject> list=new ArrayList();
        String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String querygetPays =
   	    	     "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
   	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
   	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +

   	    	     " SELECT ?HauteGamme ?nom " +
   	    	     " WHERE { ?HauteGamme vec:nom ?nom    } " ;
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("id",x);
                System.out.println(solution);
              
                System.out.println(solution.get("nom").toString().substring(solution.get("nom").toString().indexOf('#')+1));
                obj.put("label",solution.get("HauteGamme").toString().substring(solution.get("HauteGamme").toString().indexOf('#')+1));
               obj.put("nom",solution.get("nom").toString().substring(solution.get("nom").toString().indexOf('#')+1));
        
          
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/getMarques",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getMarques() {
    	
		   
        List<JSONObject> list=new ArrayList();
        String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String querygetPays =
   	    	     "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
   	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
   	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +

   	    	     " SELECT DISTINCT ?Marque  " +
   	    	     " WHERE { ?Marque vec:nom ?nom    } " ;
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("id",x);
                System.out.println(solution);
              
                System.out.println(solution.get("Marque").toString().substring(solution.get("Marque").toString().indexOf('#')+1));
                obj.put("marque",solution.get("Marque").toString().substring(solution.get("Marque").toString().indexOf('#')+1));
             //  obj.put("nom",solution.get("nom").toString().substring(solution.get("nom").toString().indexOf('#')+1));
        
          
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/getCarburants",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getCarburants() {
    	
		   
        List<JSONObject> list=new ArrayList();
        String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String querygetPays =
   	    	     "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
   	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
   	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +

				" SELECT DISTINCT ?Carburant  " +
				" WHERE { ?Carburant rdfs:subClassOf vec:Carburant} " ;
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("id",x);
                System.out.println(solution);           
                obj.put("carburant",solution.get("Carburant").toString().substring(solution.get("Carburant").toString().indexOf('#')+1));

        
          
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/getCylindres",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getCylindres() {
    	
		   
        List<JSONObject> list=new ArrayList();
        String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String querygetPays =
   	    	     "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
   	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
   	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +

 				" SELECT ?Cylindree" +
 				" WHERE {  ?Cylindree rdfs:subClassOf vec:Cylindree} " ;
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("id",x);
                System.out.println(solution);           
                obj.put("Cylindree",solution.get("Cylindree").toString().substring(solution.get("Cylindree").toString().indexOf('#')+1));

        
          
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/vehicule/{couleur}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getVecByCouleur(@PathVariable String couleur) {
    	
		   
        List<JSONObject> list=new ArrayList();
        String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String querygetPays =
            		 "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
            	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
            	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +

  					" SELECT ?voiture  " +
  					" WHERE { ?voiture vec:couleur '"+couleur+"'} " ;
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("id",x);
                System.out.println(solution);           
                obj.put("label",solution.get("voiture").toString().substring(solution.get("voiture").toString().indexOf('#')+1));

        
          
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/vehicules/{consumme}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getVecByConsumme(@PathVariable String consumme) {
    	
		   
        List<JSONObject> list=new ArrayList();
        String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String querygetPays =
            		 "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
            	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
            	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +

  					" SELECT ?voiture  " +
  					" WHERE {  ?consomme vec:consomme '"+consumme+"'} " ;
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("id",x);
                System.out.println(solution);           
                obj.put("label",solution.get("voiture").toString().substring(solution.get("voiture").toString().indexOf('#')+1));

        
          
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/getConsommes",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getConsommes() {
    	
		   
        List<JSONObject> list=new ArrayList();
        String fileName = "data/vehicules.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String querygetPays =
            		 "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
            	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
            	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
            	    	     " SELECT   DISTINCT  ?consomme " +
    		   	    	     " WHERE { ?voiture vec:consomme  ?consomme} " ;
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("id",x);
              
                obj.put("label",solution.get("consomme").toString().substring(solution.get("consomme").toString().indexOf('#')+1));

                
        
          
                list.add(obj);
            }
            System.out.println(x);
            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/getVehicules",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> queryGetallInstance() {
    	
		   
        List<JSONObject> list=new ArrayList();
        try {
            this.model = this.readModel();

            String querygetPays =
   	    	     "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +        
   	    	     "PREFIX vec: <http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#>  " +
   	    	     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +

   	    	     " SELECT ?voiture  ?consomme ?fabriquant ?couleur ?nbporte ?image" +
   	    	     " WHERE { ?voiture vec:consomme ?consomme .  ?voiture vec:est_fabrique_par ?fabriquant . ?voiture vec:couleur ?couleur . ?voiture vec:nombreDePortes ?nbporte . ?voiture vec:image ?image.  } " ;
           
            //Query query = QueryFactory.create(req1);
            QueryExecution qe = QueryExecutionFactory.create(querygetPays, this.model);
            ResultSet resultSet = qe.execSelect();
           int x=0;
            while (resultSet.hasNext()) {
                x++;
                JSONObject obj = new JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                //System.out.println(solution.get("x").toString());
                obj.put("id",x);

                obj.put("label",solution.get("voiture").toString().substring(solution.get("voiture").toString().indexOf('#')+1));
                //obj.put("type",solution.get("type").toString().substring(solution.get("type").toString().indexOf('#')+1));
                obj.put("consomme",solution.get("consomme").toString().substring(solution.get("consomme").toString().indexOf('#')+1));
                obj.put("fabriquePar",solution.get("fabriquant").toString().substring(solution.get("fabriquant").toString().indexOf('#')+1));
                obj.put("couleur",solution.get("couleur").toString());
                obj.put("nombredePorte",solution.get("nbporte").toString().substring(0, 1));
                obj.put("image",solution.get("image").toString());
                //obj.put("property",solution.get("nom").toString());
                //obj.put("object",solution.get("z").toString());
                list.add(obj);
            }
            listVehicules = list ;
            System.out.println(x);
            return listVehicules;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/add",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> AddInstance(@RequestParam("name") String name,@RequestParam("couleur") String couleur,@RequestParam("nbPorte") int nbPorte ,
    		@RequestParam("marque") String marque,@RequestParam("cylindree") String cylindree,@RequestParam("boite") String boite,@RequestParam("type") String type,@RequestParam("consomme") String consomme, @RequestParam("image") String image) {
    	
		 String NS= "http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#";
        List<JSONObject> list=new ArrayList();
        try {
            this.model = this.readModel();

         OntClass classe = this.model.getOntClass(NS+type);

         // create individual ex:jack
         Individual ind = this.model.createIndividual( NS + name, classe );

         // create some properties - probably better to use FOAF here really
         DatatypeProperty couleurP = this.model.getDatatypeProperty(NS + "couleur" );
         DatatypeProperty imageP = this.model.getDatatypeProperty(NS + "image" );
         DatatypeProperty nbPorteP = this.model.getDatatypeProperty( NS + "nombreDePortes" );
         ObjectProperty marqueP = this.model.getObjectProperty(NS + "est_fabrique_par");
         ObjectProperty consommeP = this.model.getObjectProperty(NS + "consomme");
         ObjectProperty composeP = this.model.getObjectProperty(NS + "est_compose_de");

         HasValueRestriction marqueR =
        		 this.model.createHasValueRestriction( marque, marqueP, ind );
         HasValueRestriction consommeR =
        		 this.model.createHasValueRestriction( consomme, consommeP, ind );
         HasValueRestriction composeR =
        		 this.model.createHasValueRestriction( boite, composeP, ind );
         HasValueRestriction compose1R =
        		 this.model.createHasValueRestriction( cylindree, composeP, ind );
         IntersectionClass ukIndustrialConf =
        		 this.model.createIntersectionClass( NS + "name",
        				 this.model.createList( new RDFNode[] {marqueR, consommeR,composeR,compose1R} ) );
         ind.addProperty( couleurP, this.model.createLiteral( couleur ) )
             .addProperty( nbPorteP, this.model.createTypedLiteral( nbPorte).getDatatypeURI() )
             .addProperty( imageP, this.model.createTypedLiteral( image));
         
         String output = "<!-- http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#clio -->\r\n"
         		+ "\r\n"
         		+ "    <owl:NamedIndividual rdf:about=\"http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#"+name+"\">\r\n"
         		+ "        <rdf:type rdf:resource=\"http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#"+type+"\"/>\r\n"
         		+ "        <vehicules:consomme rdf:resource=\"http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#"+consomme+"\"/>\r\n"
         		+ "        <vehicules:est_compose_de rdf:resource=\"http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#"+boite+"\"/>\r\n"
         		+ "        <vehicules:est_compose_de rdf:resource=\"http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#"+cylindree+"\"/>\r\n"
         		+ "        <vehicules:est_fabrique_par rdf:resource=\"http://www.semanticweb.org/dell/ontologies/2021/10/vehicules#"+marque.toUpperCase()+"\"/>\r\n"
         		+ "        <vehicules:couleur>"+couleur+"</vehicules:couleur>\r\n"
         		+ "        <vehicules:image>"+image+"</vehicules:image>\r\n"
         		+ "        <vehicules:nombreDePortes rdf:datatype=\"http://www.w3.org/2001/XMLSchema#integer\">"+nbPorte+"</vehicules:nombreDePortes>\r\n"
         		+ "    </owl:NamedIndividual>\r\n"
         		+ "";
         Path path = Paths.get("data/vehicules.owl");
         List<String> lines = Files.readAllLines(path);
         lines.add(12, output); // index 3: between 3rd and 4th line
         Files.write(path, lines);
         System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   
}

