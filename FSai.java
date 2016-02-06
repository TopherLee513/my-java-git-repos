// github.com/glchisenhall

// Imports

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Utilities.*;

//For possible later use
//import java.sql.*;
//import com.microsoft.sqlserver.jdbc.*;

// Warning suppression
@SuppressWarnings( {"serial", "unused"} )

// FSai 
public class FSai extends JFrame implements ActionListener
{
	private JButton m_btnExit 		= null;
	private JButton m_btnTile9 		= null;
	private JButton m_btnTile8 		= null;
	private JButton m_btnTile7 		= null;
	private JButton m_btnTile6 		= null;
	private JButton m_btnTile5 		= null;
	private JButton m_btnTile4 		= null;
	private JButton m_btnTile3 		= null;
	private JButton m_btnTile2 		= null;
	private JButton m_btnTile1 		= null;
	private JButton m_btnNewGame 	= null;
	
	// --------------------------------------------------------------------------------
	// Name: FSai
	// Abstract: Default constructor
	// --------------------------------------------------------------------------------
	public FSai()
	{
		try
		{
			Initialize( );
			
			AddControls( );
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
				
	}

	// --------------------------------------------------------------------------------
	// Name: Initialize
	// Abstract: Set Form properties
	// --------------------------------------------------------------------------------
	
	private void Initialize( )
	{
		try
		{
			int intWidth = 800;
			int intHeight = 600;
	
			// Sets title of form
			setTitle( "A Sai Loom Prod Gekt" );
			
			// Sets size of form
			setSize( intWidth, intHeight );
			
			// Sets background color
			getContentPane( ).setBackground( Color.BLACK );
			
			// Center screen
			CUtilities.CenterScreen( this );
			
			// No resizing
			setResizable( false );

			// Prevent zombie
			setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
		
	}

	// --------------------------------------------------------------------------------
	// Name: paint
	// Abstract: draw ruler
	// --------------------------------------------------------------------------------
	//Uncomment lines below to show grid marks for object placement.
	/*
	public void paint( Graphics g )
	{
		super.paint( g );
		CUtilities.DrawGridMarks( this, g );
		
    }
	*/
	// --------------------------------------------------------------------------------
	// Name: AddControls
	// Abstract: Add all the form controls
	// --------------------------------------------------------------------------------
	
	private void AddControls( )
	{
		try
		{
			// Kill layout managers
			this.setLayout( null );

			// New Game
			m_btnNewGame = AddButton( this, this, "New Game", 20, 20, 30, 180 );
				
			// Close
			m_btnExit = AddButton( this, this, "EXIT", 525, 670, 40, 120 );
						
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
		
	}
	// --------------------------------------------------------------------------------
	// Name: AddButton
	// Abstract: Add a button to the form
	// --------------------------------------------------------------------------------
	
	private JButton AddButton( Container conParent, ActionListener alParent,
							String strCaption,
							int intTop, int intLeft, 
							int intHeight, int intWidth )
	{
		
		JButton btnNewButton = null;
		
		try
		{
			// Create instance
			btnNewButton = new JButton( strCaption );
				
			// Add to parent container
			conParent.add( btnNewButton );
			
			// Set position and size 
			btnNewButton.setBounds( intLeft, intTop, intWidth, intHeight );
		
			if( alParent != null )
			{
				btnNewButton.addActionListener( alParent );
			}
			// Set font, style, and size of JButton
			btnNewButton.setFont( new Font( "Chiller", Font.BOLD, 44 ) );
		
			// Set to no border
			btnNewButton.setBorder(null);
			
			// Set to no focus border
			btnNewButton.setFocusPainted(false);
			
			// Set background color of JButton
			btnNewButton.setBackground( Color.BLACK );
			
			// Set foreground color of JButton (font color)
			btnNewButton.setForeground( Color.RED );
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
		return btnNewButton;
	}

	// --------------------------------------------------------------------------------
	// Name: actionPerformed
	// Abstract: Event handler for control click events
	// --------------------------------------------------------------------------------
	@Override
	public void actionPerformed( ActionEvent aeSource )
	{
		try
		{
			if	( aeSource.getSource( ) == m_btnNewGame )	
			{
			btnNewGame_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnExit )	
			{
			btnExit_Click( );
			}
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
	}

	// --------------------------------------------------------------------------------
	// Name: btnNewGame_Click
	// Abstract: Click event for btnNewGame
	// --------------------------------------------------------------------------------
	public void btnNewGame_Click( )
	{
		try
		{
			//Needs Utilities Package to work
			//CMessageBox.Show(this, "New Game", "Start New Game");
			gameLines(getGraphics());
			gameTiles();
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
	}

	// --------------------------------------------------------------------------------
	// Name: gameLines
	// Abstract: Draw Lines
	// --------------------------------------------------------------------------------
	
	public void gameLines( Graphics g )
	{
		try
		{
			super.paint( g );
			
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setStroke(new BasicStroke(10.0f));
	        g2.setPaint(new Color(255, 0, 0));
	        g2.drawLine(245, 218, 605, 218);
	        g2.drawLine(245, 338, 605, 338);
	        g2.drawLine(365, 95, 365, 460);
	        g2.drawLine(485, 95, 485, 460);
    	
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
	}
	
	// --------------------------------------------------------------------------------
	// Name: gameTiles
	// Abstract: Method to add game tiles
	// --------------------------------------------------------------------------------
	public void gameTiles( )
	{
		try
		{
			//Tiles
			//All tiles in reverse order, with labels to identify more easily
			m_btnTile9 = AddButton( this, this, "9", 320, 490, 105, 105 );
			m_btnTile8 = AddButton( this, this, "8", 320, 370, 105, 105 );
			m_btnTile7 = AddButton( this, this, "7", 320, 250, 105, 105 );
			m_btnTile6 = AddButton( this, this, "6", 200, 490, 105, 105 );
			m_btnTile5 = AddButton( this, this, "5", 200, 370, 105, 105 );
			m_btnTile4 = AddButton( this, this, "4", 200, 250, 105, 105 );
			m_btnTile3 = AddButton( this, this, "3", 80, 490, 105, 105 );
			m_btnTile2 = AddButton( this, this, "2", 80, 370, 105, 105 );
			m_btnTile1 = AddButton( this, this, "1", 80, 250, 105, 105 );
			
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
	}

	// --------------------------------------------------------------------------------
	// Name: btnExit_Click
	// Abstract: Click event for btnExit
	// --------------------------------------------------------------------------------
	public void btnExit_Click( )
	{
		try
		{
			this.dispose( );
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
	}
}
