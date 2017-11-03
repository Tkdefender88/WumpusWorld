package data;

public enum RoomType {
	
	GOLD("GoldTile.png", true), PIT("PitTile.png", false),
	WUMPUS("WumpusTile.png", false),  NULL("VisitedMapTile.png", true);
	
	String texture;
	boolean survivable;
	
	RoomType(String texture, boolean survivable) {
		this.texture = texture;
		this.survivable = survivable;
	}
}
