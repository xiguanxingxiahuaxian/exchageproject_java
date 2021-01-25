package com.example.exchage.controller;

import com.example.exchage.entity.*;
import com.example.exchage.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class YwController {
    /**
     * 位置添加
     */
    @Autowired
    YwMapper ywMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    DMessageMapper dMessageMapper;
    @Autowired
    DoWnifoMapper doWnifoMapper;
    @Autowired
    ReduceMapper reduceMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ScMapper scMapper;
    @Autowired
    GoodsMapper mapper;

    @RequestMapping(value = "/areaid", method = RequestMethod.GET)
    public AreaEntity areaid(@RequestParam("id") int id) {
        AreaEntity list = ywMapper.findOne(id);
        return list;
    }

    @RequestMapping(value = "/findAllAreaByType", method = RequestMethod.GET)
    public List<AreaEntity> findAllArea(@RequestParam("type") String type) {
        if (!type.equals("")) {
            return ywMapper.getArea(type);
        } else {
            return ywMapper.findAll();
        }
    }

    @RequestMapping(value = "/findAllArea", method = RequestMethod.GET)
    public List<AreaEntity> findAllArea() {
        return ywMapper.findAll();
    }

    @RequestMapping(value = "/updateArea", method = RequestMethod.POST)
    public codeAndMegDTO updateArea(@RequestBody AreaEntity areaEntity) {
        int code = ywMapper.updateArea(areaEntity.getAreaname(),
                areaEntity.getDlongtude(),
                areaEntity.getDlatitude(),
                areaEntity.getDreductprice(),
                String.valueOf(areaEntity.getId()));
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        if (code == 0) {
            codeAndMegDTO.setCode("0");
            codeAndMegDTO.setMeg("更新成功");
            return codeAndMegDTO;
        } else {
            codeAndMegDTO.setCode("-1");
            codeAndMegDTO.setMeg("更新失败");
            return codeAndMegDTO;
        }
    }

    @RequestMapping(value = "/saveArea", method = RequestMethod.POST)
    public codeAndMegDTO saveArea(@RequestBody AreaEntity areaEntity) {
        ywMapper.save(areaEntity);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("保存成功");
        return codeAndMegDTO;
    }

    @RequestMapping(value = "/deleteArea", method = RequestMethod.POST)
    public codeAndMegDTO deleteArea(@RequestBody AreaEntity areaEntity) {
        ywMapper.delete(areaEntity);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("删除成功");
        return codeAndMegDTO;
    }


    /**
     * 评论
     */
    @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
    public codeAndMegDTO saveComment(@RequestBody CommentEntity commentEntity) {
        commentMapper.save(commentEntity);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("保存成功");
        return codeAndMegDTO;
    }

    @RequestMapping(value = "/commentByareaName", method = RequestMethod.GET)
    public List<CommentEntity> commentByareaName(@RequestParam("commentByareaName") String commentByareaName) {
        return commentMapper.getAreaName(commentByareaName);
    }

    /**
     * 动态
     */
    @RequestMapping(value = "/saveDMessage", method = RequestMethod.POST)
    public codeAndMegDTO saveDMessage(@RequestBody DMessage dMessage) {
        dMessageMapper.save(dMessage);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("保存成功");
        return codeAndMegDTO;
    }

    //留言
    @RequestMapping(value = "/saveLy", method = RequestMethod.POST)
    public codeAndMegDTO saveLy(@RequestBody DoWnifno doWnifno) {
        doWnifoMapper.save(doWnifno);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("保存成功");
        return codeAndMegDTO;
    }

    //获取动态
    @RequestMapping(value = "/DmByUserName", method = RequestMethod.GET)
    public List<DMessage> DmByUserName(@RequestParam("DmByUserName") String DmByUserName) {
        return dMessageMapper.getMessage(DmByUserName);
    }

    //获取留言
    @RequestMapping(value = "/DmByMid", method = RequestMethod.GET)
    public List<DoWnifno> DmByUserName(@RequestParam("mid") int id) {
        return doWnifoMapper.geDownName(id);
    }

    //优惠
    @RequestMapping(value = "/findAllReduce", method = RequestMethod.GET)
    public List<ReduceEntity> findAllReduce() {
        return reduceMapper.findAll();
    }

    //发布优惠
    @RequestMapping(value = "/saveReduce", method = RequestMethod.POST)
    public codeAndMegDTO saveReduce(@RequestBody ReduceEntity reduceEntity) {
        reduceMapper.save(reduceEntity);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("保存成功");
        return codeAndMegDTO;
    }

    @RequestMapping(value = "/deleReduce", method = RequestMethod.POST)
    public codeAndMegDTO deleteReduce(@RequestBody ReduceEntity reduceEntity) {
        reduceMapper.delete(reduceEntity);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("删除成功");
        return codeAndMegDTO;
    }

    @RequestMapping(value = "/findOrdByUserName", method = RequestMethod.GET)
    public List<OrdEntity> findOrdByUserName(@RequestParam("findOrdByUserName") String username) {
        if (!username.equals("")) {
            return orderMapper.getUsername(username);
        } else {
            return orderMapper.findAll();
        }
    }

    @RequestMapping(value = "/deleorder", method = RequestMethod.POST)
    public codeAndMegDTO deleorder(@RequestBody OrdEntity ordEntity) {
        orderMapper.delete(ordEntity);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("删除成功");
        return codeAndMegDTO;
    }

    @RequestMapping(value = "/findOrdById", method = RequestMethod.GET)
    public OrdEntity findOrdById(@RequestParam("findOrdById") int id) {
        return orderMapper.findOne(id);
    }

    //发布优惠
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public codeAndMegDTO saveOrder(@RequestBody OrdEntity OrdEntity) {
        orderMapper.save(OrdEntity);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("保存成功");
        return codeAndMegDTO;
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.GET)
    public codeAndMegDTO updateArea(@RequestParam("state") String state, @RequestParam("id") int id) {
        int code = orderMapper.updateStatus(
                state, id);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        if (code == 0) {
            codeAndMegDTO.setCode("0");
            codeAndMegDTO.setMeg("更新订单成功");
            return codeAndMegDTO;
        } else {
            codeAndMegDTO.setCode("-1");
            codeAndMegDTO.setMeg("更新订单失败");
            return codeAndMegDTO;
        }
    }

    @RequestMapping(value = "/savesc", method = RequestMethod.POST)
    public codeAndMegDTO savesc(@RequestBody ScAreaEntity scAreaEntity) {
        scMapper.save(scAreaEntity);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("收藏成功");
        return codeAndMegDTO;
    }


    @RequestMapping(value = "/getScbyname", method = RequestMethod.GET)
    public List<ScAreaEntity> getScbyname() {
        return scMapper.findAll();
    }

  @RequestMapping(value = "/getGoods", method = RequestMethod.GET)
    public List<Goods> getGoods() {
        return mapper.findAll();
    }

    @RequestMapping(value = "/getGoodsType", method = RequestMethod.GET)
    public List<Goods> getGoodsType(@RequestParam("type") String type) {
        return mapper.getGoods(type);
    }

    @RequestMapping(value = "/getGoodsName", method = RequestMethod.GET)
    public List<Goods> getGoodsByUsernName(@RequestParam("username") String username) {
        return mapper.getUsername(username);
    }

    @RequestMapping(value = "/getGoodstitle", method = RequestMethod.GET)
    public List<Goods> getGoodsName(@RequestParam("title") String title) {
        return mapper.getGoodByGoodname(title);
    }

    @RequestMapping(value = "/savegoods", method = RequestMethod.POST)
    public codeAndMegDTO savegoods(@RequestBody Goods goods) {
        mapper.save(goods);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("上架成功");
        return codeAndMegDTO;
    }

    @RequestMapping(value = "/deletegoods", method = RequestMethod.POST)
    public codeAndMegDTO deletegoods(@RequestBody Goods goods) {
        mapper.delete(goods);
        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        codeAndMegDTO.setCode("0");
        codeAndMegDTO.setMeg("删除成功");
        return codeAndMegDTO;
    }

    @RequestMapping(value = "/updategoods", method = RequestMethod.GET)
    public codeAndMegDTO updategoods(
            @RequestParam("username") String type,
            @RequestParam("username") String desc,
            @RequestParam("username") String fastsole,
            @RequestParam("username") String newprice,
            @RequestParam("username") String oldprice,
            @RequestParam("username") String send,
            @RequestParam("username") String tel,
            @RequestParam("username") String title,
            @RequestParam("username") String imageurl,
            @RequestParam("username") String id
    ) {
        int code = mapper.updateGoods(type,
                desc,
                fastsole,
                newprice,
                oldprice,
                send,
                tel,
                title,
                imageurl,
                Integer.parseInt(id));

        codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
        if (code == 0) {
            codeAndMegDTO.setCode("0");
            codeAndMegDTO.setMeg("更新订单成功");
            return codeAndMegDTO;
        } else {
            codeAndMegDTO.setCode("-1");
            codeAndMegDTO.setMeg("更新订单失败");
            return codeAndMegDTO;
        }
    }
}
