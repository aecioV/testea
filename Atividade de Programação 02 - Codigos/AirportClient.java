/* A client program to display Airport object values
   Anderson, Franceschi
*/

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class AirportClient extends JFrame{
  String action1, action2;
  boolean firstTime = true;

  double animationPause = 5.0;      // 5 segundos entre animações
  Airport airport1, airport2;       // declare referências de objetos Airport

  public void workWithAirports( ){
    animate( "Duas referencias a objetos airport declaradas:",
                   "Airport airport1, airport2;" );

      /* Instancia um airport com lista de argumentos vazia  */
    airport1 = new Airport();
    animate( "airport1 instanciado com construtor padrao:",
                    "airport1 = new Airport( );" );

    /* atribuir airportCode como IAD */
    airport1.setAirportCode( "IAD" );
    animate( "airportCode alterado para IAD:",
                    "airport1.setAirportCode( \"IAD\" );" );

    /*  alterar numero de gates para 30 */
    airport1.setGates( 30 );
    animate( "numero de gates alterado para 30:" ,
                    "airport1.setGates( 30 );" );

    /*  Alterar numero de gates para -1, um valor invalido */
    airport1.setGates( -1 );
    animate( "tentativa de alterar o numero de gates para -1:",
                    "airport1.setGates( -1 );" );

    /*  Instanciado novo airport com construtor sobrecarregado*/
    airport2 = new Airport( "JFK", 69 );
    animate( "Instanciado airport2 com construtor sobrecarregado:",
                    "airport2 = new Airport( \"JFK\", 69 );" );

    /* Fim */
    animate( "Acoes completadas. Saindo", "" );
    System.exit(1);
   }

  public AirportClient( ){
    super( "Usando a classe Airport" );
    setSize( 300, 350 );
    setVisible( true );
  }

  public void paint( Graphics g ){
    super.paint( g );
    if ( firstTime ){
      firstTime = false;
	}
    else{
      int boxL = 75, boxH = 20;
      int sX = 50;

      int sY = 75;
      if ( airport1 != null ){
          // referencia a objeto box
          g.setColor( Color.BLACK );
          g.drawRect( sX, sY, boxL, boxH );
          g.drawString( "airport1", sX, sY - 10 );
          draw( g, sX, sY, airport1 ); // desenha objeto airport
      }
      else{
        // indica referencia null
        g.setColor( Color.BLACK );
        g.drawRect( sX, sY, boxL, boxH );
        g.drawString( "airport1", sX, sY - 10 );
        g.setColor( Color.BLUE );
        g.drawString( "null", sX + 15, sY + 15 );
      }

      sY = 200;
      if ( airport2 != null ){
          // caixa de referência a objeto
          g.setColor( Color.BLACK );
          g.drawRect( sX, sY, boxL, boxH );
          g.drawString( "airport2", sX, sY - 10 );
          draw( g, sX, sY, airport2 ); // desenha objeto airport
       }
       else{
          // indica referencia null
            g.setColor( Color.BLACK );
            g.drawRect( sX, sY, boxL, boxH );
            g.drawString( "airport2", sX, sY - 10 );
            g.setColor( Color.BLUE );
            g.drawString( "null", sX + 15, sY + 15 );
       }

       // apresentar ação na parte inferior da tela
       g.setColor( Color.BLUE );
       g.drawString( action1, 20, 320 );
       g.drawString( action2, 35, 335 );

    }
  }

  private void draw( Graphics g, int sX, int sY, Airport a ){
    int boxL = 75, boxH = 20;

    // seta
    g.setColor( Color.BLACK );
    g.drawLine( sX + boxL, sY + boxH / 2,
                 sX + boxL + 25, sY + boxH / 2 );
    g.drawLine( sX + boxL + 25, sY + boxH / 2,
                 sX + boxL + 25, sY + boxH * 2 );
    g.drawLine( sX + boxL + 25 - 5, sY + boxH * 2 - 5,
                 sX + boxL + 25, sY + boxH * 2 );
    g.drawLine( sX + boxL + 25 + 5, sY + boxH * 2 - 5,
                 sX + boxL + 25, sY + boxH * 2 );

    // airportCode
    g.setColor( Color.BLACK );
    g.drawString( "airport code", sX + boxL - 75, sY + 2 * boxH + 15 );
    g.drawRect( sX + boxL, sY + 2 * boxH, boxL, boxH );
    g.setColor( Color.BLUE );
    g.drawString( a.getAirportCode(),
                  sX + boxL + 5, sY + 2 * boxH + 15);

    // gates
    g.setColor( Color.BLACK );
    g.drawString( "gates", sX + boxL - 75, sY + 3 * boxH + 15 );
    g.drawRect( sX + boxL, sY + 3 * boxH, boxL, boxH );
    g.setColor( Color.BLUE );
    g.drawString( Integer.toString( a.getGates() ),
                  sX + boxL + 5, sY + 3 * boxH + 15 );

  }

  private void animate( String a1, String a2 ){
    action1 = a1;
    action2 = a2;
    repaint( );
    Pause.wait( animationPause );
  }

  public static void main( String [] args ){
    AirportClient app = new AirportClient( );
    app.workWithAirports( );
    app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
