import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: 青菜
 * @Date: 2019/5/6 上午10:33
 * @Description: 微信回调controller
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/mp")
public class MP3rdReceiveController {

    private ModelAndView receiveAuthCallBack() {

        return new ModelAndView("redirect:/admin/index.html");
    }

}
