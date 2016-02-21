// github.com/glchisenhall

// ----------------------------------------------------------------------
// Name: Gary Chisenhall 
// Class: CTheLoom
//
// Version		Notes
// 2016/02/08		Main
// ----------------------------------------------------------------------


//Imports
import Insanities.*;

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
			CInsanities.WriteLog( excError );
		}

	}

}
