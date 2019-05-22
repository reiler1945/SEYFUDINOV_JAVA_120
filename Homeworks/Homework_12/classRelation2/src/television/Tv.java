package television;

public class Tv {
	//текущий выбранный канал
	private Channel currentChannel; 
	
	//список всех каналов у ТВ 
	private Channel[] channels;
	
	//выбрать канал по номеру
	public void setChannel(int numChannel){
		System.out.println("trying to set the Channel #" + numChannel);
		currentChannel = getChannelByNum(numChannel);
		if (currentChannel != null) {
			System.out.println("It was set the Channel #" + numChannel);
		}
	}	
	
	//получить текущий канал
	public Channel getCurrentChannel(){
		return currentChannel;
	}		
		
	//привяжем список каналов к ТВ
	public void setChannels(Channel[] channels) {
		this.channels = channels;
		//TODO: как реализовать этот метод, если необходимо скопировать не ссылку, а сами объекты, входящие в состав channels?
	}	
	
	//выбираем канал из списка по номеру
	private Channel getChannelByNum(int numChannel) {
		for (int i = 0; i < channels.length; i++) {
			if (numChannel == channels[i].getNumber()) {
				return channels[i];
			}
		}
		System.err.println("No Channel #" + numChannel);
		return null;
	}
}
