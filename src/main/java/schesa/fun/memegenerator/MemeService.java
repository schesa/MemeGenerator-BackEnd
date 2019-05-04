package schesa.fun.memegenerator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemeService {

    ArrayList<String> tops;
    ArrayList<String> bottoms;

    public MemeService(){
        tops = new ArrayList<>();
        tops.add("When you see that");
        tops.add("When your mother sees that");
        tops.add("When your dog says that");
        tops.add("When your GF hears that");
        bottoms = new ArrayList<>();
        bottoms.add("you have a lame backend");
        bottoms.add("you have shiny tiny");
        bottoms.add("you watch GOT");
        bottoms.add("you don't like dogs");
        bottoms.add("you don't like cats");
    }

    public Meme getRandomMeme(){
        int randomNumber = getRandomNumber(1,8);
        String topText = getRandomTop();
        String bottomText = getRandomBottom();

        return new Meme("assets/meme-templates/"+randomNumber+".jpg", topText, bottomText);
    }

    private int getRandomNumber(int min, int range){
        return ((int) (Math.random()*range))+min;
    }
    private String getRandomTop(){
        int randomNumber = getRandomNumber(0,tops.size());
        return tops.get(randomNumber);
    }
    private String getRandomBottom(){
        int randomNumber = getRandomNumber(0,bottoms.size());
        return bottoms.get(randomNumber);
    }

}
