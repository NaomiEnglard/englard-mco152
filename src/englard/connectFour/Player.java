package englard.connectFour;

import javax.swing.ImageIcon;

public class Player {

	private int playerNum;
	private ImageIcon piecePic;
	private String color;

	public Player(int num, ImageIcon pic, String color) {
		this.playerNum = num;
		this.piecePic = pic;
		this.color = color;
	}

	public int getPlayerNum() {
		return this.playerNum;
	}

	public ImageIcon getPiecePicture() {
		return this.piecePic;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerNum != other.playerNum)
			return false;
		return true;
	}

	public String getColor() {
		return this.color;
	}
}
