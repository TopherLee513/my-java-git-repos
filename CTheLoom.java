// github.com/glchisenhall


//Imports
import Utilities.*;

public class CTheLoom 
{

	public static void main(String[] args) 
	{
		try
		{
			FSai frmSai = new FSai( );
			
			frmSai.setVisible( true );
		}
		catch( Exception excError)
		{
			CUtilities.WriteLog( excError );
		}

	}

}
