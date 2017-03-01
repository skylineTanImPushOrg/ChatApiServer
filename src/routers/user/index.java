package routers.user;

import com.alibaba.fastjson.JSONObject;
import com.github.timeloveboy.moeserver.DefaultHandle;
import com.github.timeloveboy.moeserver.IHttpRequest;
import com.github.timeloveboy.moeserver.IHttpResponse;
import model.User;
import utils.StreamUtil;

/**
 * Created by timeloveboy on 17-3-1.
 */
public class index extends DefaultHandle {
    @Override
    public void POST(IHttpRequest req, IHttpResponse resp) throws Exception {
        String bs = StreamUtil.getBody(req.getBody());
        JSONObject o = (JSONObject) JSONObject.parse(bs);
        Integer uid = 0;
        uid = o.getInteger("uid");
        String pwd = o.getString("pwd");

        User u = (User) JSONObject.parse(bs);
        if (uid != 0 && u != null) {
            if (User.CanRegiste(uid)) {
                User.Registe(u, pwd);
            }
        } else {
            resp.write("require uid && user");
        }
    }
}
