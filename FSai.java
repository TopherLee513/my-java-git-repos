// github.com/glchisenhall
// By: Gary Chisenhall
// February 2016

// Imports
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Utilities.*;
import Utilities.CMessageBox.enuButtonType;
import Utilities.CMessageBox.enuIconType;

//For possible later use
//import java.sql.*;
//import com.microsoft.sqlserver.jdbc.*;

// Warning suppression
@SuppressWarnings( {"serial"} )

// FSai 
public class FSai extends JFrame implements ActionListener
{
	private String[] 	SYMBOLS			= {"X", "O"};
	private int 		PLAYER_TURN		= 0;
	private JButton 	m_btnExit 		= null;
	private JButton 	m_btnTile9 		= null;
	private JButton 	m_btnTile8 		= null;
	private JButton 	m_btnTile7 		= null;
	private JButton 	m_btnTile6 		= null;
	private JButton 	m_btnTile5 		= null;
	private JButton 	m_btnTile4 		= null;
	private JButton 	m_btnTile3 		= null;
	private JButton 	m_btnTile2 		= null;
	private JButton 	m_btnTile1 		= null;
	private JButton 	m_btnNewGame 	= null;
	
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
			m_btnNewGame = AddButton( this, this, "New Game", 'n', 20, 20, 30, 180 );

			//Tiles
			//All tiles in reverse order, with labels to identify more easily
			m_btnTile9 = AddButton( this, this, "", '9', 320, 490, 105, 105 );
			m_btnTile8 = AddButton( this, this, "", '8', 320, 370, 105, 105 );
			m_btnTile7 = AddButton( this, this, "", '7', 320, 250, 105, 105 );
			m_btnTile6 = AddButton( this, this, "", '6', 200, 490, 105, 105 );
			m_btnTile5 = AddButton( this, this, "", '5', 200, 370, 105, 105 );
			m_btnTile4 = AddButton( this, this, "", '4', 200, 250, 105, 105 );
			m_btnTile3 = AddButton( this, this, "", '3', 80, 490, 105, 105 );
			m_btnTile2 = AddButton( this, this, "", '2', 80, 370, 105, 105 );
			m_btnTile1 = AddButton( this, this, "", '1', 80, 250, 105, 105 );
			

			m_btnTile9.setEnabled(false);
			m_btnTile8.setEnabled(false);
			m_btnTile7.setEnabled(false);
			m_btnTile6.setEnabled(false);
			m_btnTile5.setEnabled(false);
			m_btnTile4.setEnabled(false);
			m_btnTile3.setEnabled(false);
			m_btnTile2.setEnabled(false);
			m_btnTile1.setEnabled(false);
			
			// Close
			m_btnExit = AddButton( this, this, "EXIT", 'x', 525, 670, 40, 120 );
						
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
							String strCaption, char chrKeyboardShortcut,
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

			// Keyboard shortcut?
			if( chrKeyboardShortcut != ' ' ) btnNewButton.setMnemonic( chrKeyboardShortcut );
			
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
	public void actionPerformed( ActionEvent aeSource )
	{
		try
		{
			if	( aeSource.getSource( ) == m_btnNewGame )	
			{
			btnNewGame_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile9 )	
			{
			btnTile9_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile8 )	
			{
			btnTile8_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile7 )	
			{
			btnTile7_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile6 )	
			{
			btnTile6_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile5 )	
			{
			btnTile5_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile4 )	
			{
			btnTile4_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile3 )	
			{
			btnTile3_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile2 )	
			{
			btnTile2_Click( );
			}
			else if	( aeSource.getSource( ) == m_btnTile1 )	
			{
			btnTile1_Click( );
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
			m_btnTile9.setText("");
			m_btnTile8.setText("");
			m_btnTile7.setText("");
			m_btnTile6.setText("");
			m_btnTile5.setText("");
			m_btnTile4.setText("");
			m_btnTile3.setText("");
			m_btnTile2.setText("");
			m_btnTile1.setText("");
			
			m_btnTile9.setEnabled(true);
			m_btnTile8.setEnabled(true);
			m_btnTile7.setEnabled(true);
			m_btnTile6.setEnabled(true);
			m_btnTile5.setEnabled(true);
			m_btnTile4.setEnabled(true);
			m_btnTile3.setEnabled(true);
			m_btnTile2.setEnabled(true);
			m_btnTile1.setEnabled(true);
		}
		catch( Exception excError )
		{
			// Display error message
			CUtilities.WriteLog( excError );
		}
	}
//region Game Tile Actions

		// --------------------------------------------------------------------------------
		// Name: Tile 9 Click
		// Abstract: Method to activate tile 9
		// --------------------------------------------------------------------------------
		public void btnTile9_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile9.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile9.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile9.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}
		// --------------------------------------------------------------------------------
		// Name: Tile 8 Click
		// Abstract: Method to activate tile 8
		// --------------------------------------------------------------------------------
		public void btnTile8_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile8.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile8.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile8.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}
		// --------------------------------------------------------------------------------
		// Name: Tile 7 Click
		// Abstract: Method to activate tile 7
		// --------------------------------------------------------------------------------
		public void btnTile7_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile7.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile7.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile7.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}
		// --------------------------------------------------------------------------------
		// Name: Tile 6 Click
		// Abstract: Method to activate tile 6
		// --------------------------------------------------------------------------------
		public void btnTile6_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile6.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile6.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile6.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}
		// --------------------------------------------------------------------------------
		// Name: Tile 5 Click
		// Abstract: Method to activate tile 5
		// --------------------------------------------------------------------------------
		public void btnTile5_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile5.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile5.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile5.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}
		// --------------------------------------------------------------------------------
		// Name: Tile 4 Click
		// Abstract: Method to activate tile 4
		// --------------------------------------------------------------------------------
		public void btnTile4_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile4.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile4.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile4.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}	
		// --------------------------------------------------------------------------------
		// Name: Tile 3 Click
		// Abstract: Method to activate tile 3
		// --------------------------------------------------------------------------------
		public void btnTile3_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile3.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile3.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile3.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}
		// --------------------------------------------------------------------------------
		// Name: Tile 2 Click
		// Abstract: Method to activate tile 2
		// --------------------------------------------------------------------------------
		public void btnTile2_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile2.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile2.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile2.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}
		// --------------------------------------------------------------------------------
		// Name: Tile 1 Click
		// Abstract: Method to activate tile 1
		// --------------------------------------------------------------------------------
		public void btnTile1_Click( )
		{
			try
			{				
				// If the tile is not empty, exit the function
			    if(!m_btnTile1.isEnabled()) {
			        return;
			    }
			    else
			    // Put the player's symbol on the tile
			    m_btnTile1.setText(SYMBOLS[PLAYER_TURN]);
			  //Tile button disabled
			    m_btnTile1.setEnabled(false);
				    // Change the turn
			    PLAYER_TURN++;
			    if(PLAYER_TURN >= SYMBOLS.length) {
			    	PLAYER_TURN = 0;
			    }
			    checkWin();
			}
			catch( Exception excError )
			{
				// Display error message
				CUtilities.WriteLog( excError );
			}
		}
//endregion
		
		// --------------------------------------------------------------------------------
		// Name: checkWin
		// Abstract: Check for win scenario
		// --------------------------------------------------------------------------------
			
		public void checkWin() {
			
			if(		m_btnTile1.getText() == "X" && m_btnTile2.getText() == "X" && m_btnTile3.getText() == "X" ||
					m_btnTile4.getText() == "X" && m_btnTile5.getText() == "X" && m_btnTile6.getText() == "X" ||
					m_btnTile7.getText() == "X" && m_btnTile8.getText() == "X" && m_btnTile9.getText() == "X" ||
					m_btnTile1.getText() == "X" && m_btnTile5.getText() == "X" && m_btnTile9.getText() == "X" ||
					m_btnTile3.getText() == "X" && m_btnTile5.getText() == "X" && m_btnTile7.getText() == "X" ||
					m_btnTile1.getText() == "X" && m_btnTile4.getText() == "X" && m_btnTile7.getText() == "X" ||
					m_btnTile2.getText() == "X" && m_btnTile5.getText() == "X" && m_btnTile8.getText() == "X" ||
					m_btnTile3.getText() == "X" && m_btnTile6.getText() == "X" && m_btnTile9.getText() == "X") {
				CMessageBox.Show(this, "Player one wins!", "Winner", enuIconType.Warning, enuButtonType.OK);
				btnNewGame_Click();
			}
			else if(m_btnTile1.getText() == "O" && m_btnTile2.getText() == "O" && m_btnTile3.getText() == "O" ||
					m_btnTile4.getText() == "O" && m_btnTile5.getText() == "O" && m_btnTile6.getText() == "O" ||
					m_btnTile7.getText() == "O" && m_btnTile8.getText() == "O" && m_btnTile9.getText() == "O" ||
					m_btnTile1.getText() == "O" && m_btnTile5.getText() == "O" && m_btnTile9.getText() == "O" ||
					m_btnTile3.getText() == "O" && m_btnTile5.getText() == "O" && m_btnTile7.getText() == "O" ||
					m_btnTile1.getText() == "O" && m_btnTile4.getText() == "O" && m_btnTile7.getText() == "O" ||
					m_btnTile2.getText() == "O" && m_btnTile5.getText() == "O" && m_btnTile8.getText() == "O" ||
					m_btnTile3.getText() == "O" && m_btnTile6.getText() == "O" && m_btnTile9.getText() == "O"){
				CMessageBox.Show(this, "Player two wins!", "Winner", enuIconType.Warning, enuButtonType.OK);
				btnNewGame_Click();
			}
			else if(!m_btnTile1.isEnabled()&& !m_btnTile2.isEnabled()&& !m_btnTile3.isEnabled()&&
					!m_btnTile4.isEnabled()&& !m_btnTile5.isEnabled()&& !m_btnTile6.isEnabled()&&
					!m_btnTile7.isEnabled()&& !m_btnTile8.isEnabled()&& !m_btnTile9.isEnabled()){

				CMessageBox.Show(this, "Draw!", "No Winner", enuIconType.Warning, enuButtonType.OK);
				btnNewGame_Click();
			
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
