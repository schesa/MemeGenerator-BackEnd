package schesa.fun.memegenerator;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class MemeController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private MemeService memeService;


    @CrossOrigin("http://localhost:4200")
    @GetMapping("/meme")
    public Meme getMeme(){
        return memeService.getRandomMeme();
    }

//    @CrossOrigin("http://localhost:4200")
//    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
//    public void getImage(HttpServletResponse response) throws IOException {
//        ClassPathResource imgFile = new ClassPathResource("image/772.png");
//        response.setContentType(MediaType.IMAGE_PNG_VALUE);
//        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
//    }

//    @PostMapping("/uploadImage")
//    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
//        String returnValue = "start";
//
//        PhotoDTO photoDTO = new PhotoDTO();
//        photoDTO.setFileName(imageFile.getOriginalFilename());
//        photoDTO.setPath("/photo/");
//
//        try {
//
////            memeService.saveImage(imageFile, photoDTO);
//            savePhotoImage(photoDTO,imageFile);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            returnValue = "error";
//        }
//
//        return returnValue;
//    }
//
//    public void savePhotoImage(PhotoDTO photoDTO, MultipartFile imageFile) throws Exception {
//        // this gets us to src/main/resources without knowing the full path (hardcoding)
//        Path currentPath = Paths.get(".");
//        Path absolutePath = currentPath.toAbsolutePath();
//        photoDTO.setPath(absolutePath + "/src/main/resources/static/photos/");
//        byte[] bytes = imageFile.getBytes();
//        Path path = Paths.get(photoDTO.getPath() + imageFile.getOriginalFilename());
//        Files.write(path, bytes);
//        kafkaTemplate.send("photoIn", path.normalize().toString());
//    }
}
