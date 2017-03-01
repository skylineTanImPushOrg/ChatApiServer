package routers.user;

import cache.RedisCache;
import com.alibaba.fastjson.JSONObject;
import com.github.timeloveboy.moeserver.DefaultHandle;
import com.github.timeloveboy.moeserver.IHttpRequest;
import com.github.timeloveboy.moeserver.IHttpResponse;
import model.User;
import utils.StreamUtil;

import java.util.Date;


/**
 * Created by timeloveboy on 17-3-1.
 */
public class login extends DefaultHandle {
    @Override
    public void POST(IHttpRequest req, IHttpResponse resp) throws Exception {
        JSONObject o = (JSONObject) JSONObject.parse(StreamUtil.getBody(req.getBody()));
        Integer uid = 0;
        uid = o.getInteger("uid");
        String pwd = o.getString("pwd");
        if (uid != 0) {
            User user = new User(uid);
            if (user.Login(pwd)) {
                RedisCache.getInstance().set(uid.toString(), Long.toString(new Date().getTime()));
                resp.write("login success");
            } else {
                resp.write("pwd error");
            }
        } else {
            resp.write("require uid");
        }
    }
}
