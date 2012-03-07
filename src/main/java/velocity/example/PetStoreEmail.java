package velocity.example;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class PetStoreEmail {
	public static void main( String[] args )
    throws Exception
{
    /*  first, get and initialize an engine  */
    VelocityEngine ve = new VelocityEngine();
    ve.init();
    /*  organize our data  */
    List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    Map<String,String> map = new HashMap<String,String>();
    map.put("name", "horse");
    map.put("price", "00.00");
    list.add( map );

    map = new HashMap<String,String>();
    map.put("name", "dog");
    map.put("price", "9.99");
    list.add( map );
    map = new HashMap<String,String>();
    map.put("name", "bear");
    map.put("price", ".99");
    list.add( map );
    /*  add that list to a VelocityContext  */
    VelocityContext context = new VelocityContext();
    context.put("petList", list);
    /*  get the Template  */
    Template t = ve.getTemplate( "petonsale.vm" );
    /*  now render the template into a Writer  */
    StringWriter writer = new StringWriter();
    t.merge( context, writer );
    /* use the output in your email body */
System.out.print(writer.toString());
  //sendEmail( writer.toString() );
}
}
