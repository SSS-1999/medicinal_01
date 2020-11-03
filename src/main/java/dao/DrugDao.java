package dao;


import pojo.Drug;


import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//这个类是用来操作tb_user表的CRUD操作
public class DrugDao {


    //写一个添加用户数据的方法  对于添加操作  、删除操作、修改操作
    //方法的返回值都可以是表中数据的受影响的行数 int
    // 查询 将每一条数据封装一个对象中，将多个对象添加集合中
    public int addDrugInfo(Integer drugId,String mediname, String price,String DUser) {
        //获取数据库连接对象
        Connection Dconnconn = null;
        PreparedStatement Dps = null;
        int row = 0;




        try {
            Dconnconn = DBUtil.getConn();
            System.out.println("Dconn:" + Dconnconn);
            //写sql
            String sql = "insert into tb_drug(drugId,drugName,drugPrice,drugUser) values(null,?,?,?)";
            Dps = Dconnconn.prepareStatement(sql);
            //给问号赋值

            Dps.setString(1, mediname);
            Dps.setString(2,price);
            Dps.setString(3, "cc");

            //执行
            row = Dps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                Dconnconn.close();
                Dps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return row;
    }





    //添加药品
    public int addDrugInfo(Drug drug) {
        //获取数据库的连接对象
        Connection Dconn = null;
        PreparedStatement Dps = null;
        int row = 0;

        try {
            Dconn = DBUtil.getConn();
            System.out.println("Dconn:" + Dconn);
            //创建SQL
            String sql = "insert into tb_drug(drugId,drugName,drugPrice,drugUser) values(null,?,?,?)";
            Dps = Dconn.prepareStatement(sql);
            //给问号赋值
            Dps.setString(1, drug.getDrugName());
            Dps.setString(2, drug.getDrugPrice());
            Dps.setString(3, drug.getDrugUser());

            //执行
            row = Dps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                Dconn.close();
                Dps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;


    }


    //查询tb_drug表中所有数据
    public List<Drug> findAllDrugInfo() {
        List<Drug> Dlist = new ArrayList<>();
        //获取数据库连接
        Connection Dconnection = DBUtil.getConn();
        //编写sql
        String sql = "select * from tb_drug";

        try {
            // PreparedStatement
            PreparedStatement Dps = Dconnection.prepareStatement(sql);
            //因为没有参数 不用给问号赋值  省略
            ResultSet Dr = Dps.executeQuery();
            //遍历结果集 ，将数据封装到User对象，将对象添加到集合中
            while (Dr.next()) {


                Integer  drugId = Dr.getInt("drugId");
                String mediname = Dr.getString("drugName");
                String price = Dr.getString("drugPrice");
                String DUser = Dr.getString("drugUser");
                //将得到的数据封装到对象
                Drug drug = new Drug();
                drug.setDrugName(mediname);
                drug.setDrugPrice(price);

                drug.setDrugUser(DUser);
                drug.setDrugId(drugId);
                //将封装数据的对象添加到集合中
                Dlist.add(drug);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                Dconnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return Dlist;
    }


    //根据drugId删除数据
    public int deleteDrugById(String drugId){
        int row=0;
        //获取数据库连接
        Connection Dconn=DBUtil.getConn();
        //编写sql
        String sql="delete  from tb_drug where drugId=?";

        try {
            // 创建 PreparedStatement对象
            PreparedStatement Dps= Dconn.prepareStatement(sql);
            //给问号赋值
            Dps.setInt(1,Integer.parseInt(drugId));
            //执行
            row=Dps.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                Dconn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  row;
    }





    //根据id查找当前药品
    public Drug findDrugInfo(String drugId){
        Drug drug=null;
        //获取数据连接
        Connection Dconn=DBUtil.getConn();
        //编写sql
        String sql="select * from tb_drug where drugId=?";
        //创建PreparedStatement 对象
        try {
            PreparedStatement Dps=Dconn.prepareStatement(sql);
            //给问号赋值
            Dps.setInt(1,Integer.parseInt(drugId));
            //执行
            ResultSet Dr=Dps.executeQuery();
            //遍历结果集




            if(Dr.next()){
                Integer drug_id= Dr.getInt("drugId");
                String drug_name=Dr.getString("drugName");
                String drug_price=Dr.getString("drugPrice");
                String drug_user=Dr.getString("drugUser");
                //将取出的数据封装到对象
                drug=new Drug();
                drug.setDrugId(drug_id);
                drug.setDrugName(drug_name);
                drug.setDrugPrice(drug_price);
                drug.setDrugUser(drug_user);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                Dconn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  drug;
    }


    //根据id执行药品信息的修改
    public int  toUpdateDrugInfo(String drugid,String drugname,String drugprice,String druguser){
        //获取连接对象
        Connection Dconn = DBUtil.getConn();
        int row=0;
        //编写sql


        String sql="update tb_drug set drugPrice=?,drugUser=? where drugId=?";
        //得到PreparedStatement对象
        try {
            PreparedStatement Dps= Dconn.prepareStatement(sql);

            //给问号赋值
            Dps.setString(1,drugprice);
            Dps.setString(2,druguser);
            Dps.setInt(3,Integer.parseInt(drugid));
            //执行
            row=Dps.executeUpdate();
            //返回受影响行数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                Dconn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  row;
    }




}
