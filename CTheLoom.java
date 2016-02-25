// ----------------------------------------------------------------------
// TicTacTux-GUI
// Name: Gary Chisenhall
// https://github.com/glchisenhall
// Class: CTheLoom
//
// Version			Notes
// 2016/02/08		Created as v0.1 	- Form layout and grid lines
// 2016/02/10		Updated to v0.2b 	- Working game with support files
// 2016/02/21		Updated to v0.3		- Updated to independent file structure
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
