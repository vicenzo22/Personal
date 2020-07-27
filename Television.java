package edu.cuny.csi.csc330.lab4;
import java.util.*;

import java.time.format.DateTimeFormatter;

import edu.cuny.csi.csc330.util.Randomizer;
public class Television {
	/**
	 choose from local channels or  netflix series. 
	 */
	public static class Input {
		
		public static int[] generateInitialPresets(int size, double from, double to) {
			
			int[] presets = new int[size];
			
			for(int i = 0 ; i  < presets.length ; i++ ) {
				presets[i] = Randomizer.generateInt(from, to);
			}
			
			return presets;
		}
			//I borrowed professors randomizer class and some defaults 
		static public class Local { 
			public final static String name = "Local";
			public final static int MAX_CHANNELS = 15;
			public final static double LOW_CHANNEL = 1;
			public final static double HIGH_CHANNEL = 16;
			 
			public static int [] generateInitialPresets() {
				return Input.generateInitialPresets(MAX_CHANNELS, LOW_CHANNEL, HIGH_CHANNEL);
			}
		}
		public static class Netflix { 
			public final static String name = "Netflix";
			public final static int MAX_CHANNELS = 6;
			public final static int LOW_CHANNEL = 1;
			public final static int HIGH_CHANNEL = 5;
			 
		
		}
		
	}
		protected static final int MIN_VOLUME = 0;
		protected static final int MAX_VOLUME = 40;
		protected static final int DEFAULT_VOLUME = 20;
		protected static final String DEFAULT_Input = Input.Local.name;
		protected static final int DEFAULT_Channel = 4;
		protected static final String Default_CH="HDM2";
		protected static final String DEFAULT_PIC = "VIVID";
		protected static final int DEFAULT_Brightness = 50;
		protected static final String DEFAULT_Language = "English";
		
		
		private boolean powerState; 
		private int selectedVolume;
		private int selectedChannel;
		private String Channel;
		private String selectedInput;
		private int[] LocalCH;
		private String[] Netflix;
		private Date firstTimeOn;
		private Date lastTimeOn;
		private String selectedPic; 
		private int selectedBrightness; 
		private String Language; 
		
	
		public void on() {
			Date now = new Date(); 
			
			// Turning on the TV 
			if(firstTimeOn == null) {
			
				LocalCH = Input.Local.generateInitialPresets();  
				Netflix=new String[] {"The Joker","Money Heist","Breaking Bad","Narcos","The GodFather","Finding Nemo"};  
				firstTimeOn = now; 
				// Volume and Channel unless you are in netflix  
				selectedVolume = DEFAULT_VOLUME; 
				selectedInput = DEFAULT_Input;
				selectedChannel = DEFAULT_Channel; 
				Channel=Default_CH;
				// some settings like language and picture. 
				selectedPic = DEFAULT_PIC; 
				Language = DEFAULT_Language; 
				selectedBrightness = DEFAULT_Brightness; 
			}
			
			powerState = true; 
			lastTimeOn = now; 
			
		}
		
		/**
		 * turn off the radio instance 
		 * @return 
		 */
		public boolean off() {
			return powerState = false; 
		}


		/**
		 * is the radio powerState on/off??
		 * @return
		 */
		public boolean isOn() {
			return powerState == true;
		}
		
		
		public int getVolume() {
			return selectedVolume;
		}
		public void setVolume(int volume) {
			this.selectedVolume = volume;
		}
		
		public void decreaseVolume(int volume) {
			this.selectedVolume -= volume;
		}
		
		public void increaseVolume(int volume) {
			this.selectedVolume += volume;
		}

		public double getSelectedChannel() {
			return selectedChannel;
		}
		public void getNetflix(String netflix) {
	
	this.Channel=netflix;
	
}
		public void setSelectedChannel(int selectedChannel) {
			this.selectedChannel = selectedChannel;
		}

		public String getSelectedInput() {
			return selectedInput;
		}
		public void setSelectedInput(String selectedInput) {
			this.selectedInput = selectedInput;
		}

		/*public String[] getFmPresets() {
			return Netflix;
		}*/


		public Date getFirstTimeOn() {
			return firstTimeOn;
		}
		public String getSelectedBalance() {
			return selectedPic;
		}

		public void setSelectedBalance( String selectedPic) {
			this.selectedPic = selectedPic;
		}

		public int getSelectedBrightness() {
			return selectedBrightness;
		}

		public void setSelectedBrightness(int selectedBrightness) {
			this.selectedBrightness = selectedBrightness;
		}

		public String Language() {
			return Language;
		}

		public void Language(String Language) {
			this.Language = Language;
		}
		
		public void assignToPreset( int position, int station,String Channel) {
			if(Input.Local.name.equals(this.selectedInput)) {
				this.LocalCH[position - 1] = station; 
			}
			else if(Input.Netflix.name.equals(this.selectedInput)) {
				this.Netflix[position - 1] = Channel; 
			}
		}
		
		// Select from Preset - from current band 
		public void selectFromPreset(int position) {
			if(Input.Local.name.equals(this.selectedInput)) {
				this.selectedChannel = this.LocalCH[position - 1]; 
			}
			else if(Input.Netflix.name.equals(this.selectedInput)) {
				this.Channel = this.Netflix[position - 1]; 
			}
		}
		
		@Override
		public String toString() {
			return "TV Instance: " + " powerState= " + powerState + ", Volume= "
					+ selectedVolume + ", CH= " + selectedChannel +" Input= "+ Channel  
					+ ", Using= " + selectedInput + "\n Local Channels="
					+ Arrays.toString(LocalCH) + ",\n Netflix Series="
					+ Arrays.toString(Netflix) + ",\n firstTimeOn=" + firstTimeOn
					+ ", lastTimeOn=" + lastTimeOn + ", Picture=" + selectedPic
					+ ", Brightness=" + selectedBrightness
					+ ", Language=" + Language + "\n";
		}

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			// Create instance of - power up & down ... other ops, and 
			//  display the powerState of the Radio instance 
			Television television = new Television();  
			
			System.out.println("New Instance\n" + television + "\n");
			
			// turn it on
			television.on(); 
			System.out.println("Turned On\n" + television + "\n");
			
			// select FM Band & a station 
			television.setSelectedInput(Television.Input.Netflix.name); 
			television.getNetflix("HDM1");
			television.setSelectedChannel(0); 
			System.out.println("Changed to Netflix\n" + television + "\n");
			
			// assign a station to a preset on FM 
			television.assignToPreset(1,  101,"Stranger Things"); 
			television.selectFromPreset(1);
			System.out.println("Selecting Stranger Things  " + television.getSelectedInput() + "\n" + television + "\n");
			
			// Turn off radio 
			television.off(); 
			System.out.println("Turned Off\n" + television + "\n");

		}

	}
