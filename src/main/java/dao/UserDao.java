package dao;

import pojo.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//这个类是用来操作tb_user表的CRUD操作
public class UserDao {

    //写一个添加用户数据的方法  对于添加操作  、删除操作、修改操作
    //方法的返回值都可以是表中数据的受影响的行数 int
    // 查询 将每一条数据封装一个对象中，将多个对象添加集合中
    public int addUserInfo(String name, String pwd) {
        //获取数据库连接对象
        Connection conn = null;
        PreparedStatement ps = null;
        int row = 0;

        try {
            conn = DBUtil.getConn();
            System.out.println("conn:" + conn);
            //写sql
            String sql = "insert into tb_user(id,name,password,tel) values(null,?,?,?)";
            ps = conn.prepareStatement(sql);
            //给问号赋值
            ps.setString(1, name);
            ps.setString(2, pwd);
            ps.setString(3, "13411375191");

            //执行
            row = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return row;
    }


    //封装一个方法   根据用户名查询当前用户是否存在
    public User findUserByUserName(String name) {
        //获取数据库连接对象
        Connection conn = DBUtil.getConn();
        User user = null;
        //编写sql
        String sql = "select * from tb_user where name=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            // 给问号赋值
            ps.setString(1, name);

            //执行
            ResultSet r = ps.executeQuery();

            if (r.next()) {
                int id = r.getInt("id");
                String username = r.getString("name");
                String pwd = r.getString("password");
                String tel = r.getString("tel");
                //得到结果封装到User对象
                //将从数据库拿到的这条数据封装到一个User对象
                user = new User();
                user.setId(id);
                user.setName(username);
                user.setPassword(pwd);
                user.setTel(tel);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭连接
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;

    }

    //查询tb_user表中所有数据
    public List<User> findAllUserInfo() {
        List<User> list = new ArrayList<>();
        //获取数据库连接
        Connection connection = DBUtil.getConn();
        //编写sql
        String sql = "select * from tb_user";

        try {
            // PreparedStatement
            PreparedStatement ps = connection.prepareStatement(sql);
            //因为没有参数 不用给问号赋值  省略
            ResultSet r = ps.executeQuery();
            //遍历结果集 ，将数据封装到User对象，将对象添加到集合中
            while (r.next()) {
                Integer id = r.getInt("id");
                String name = r.getString("name");
                String pwd = r.getString("password");
                String phone = r.getString("tel");
                //将得到的数据封装到对象
                User user = new User();
                user.setId(id);
                user.setPassword(pwd);
                user.setName(name);
                user.setTel(phone);
                //将封装数据的对象添加到集合中
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    //根据id删除数据
    public int deleteUserById(String id){
        int row=0;
    //获取数据库连接
        Connection conn=DBUtil.getConn();
        //编写sql
        String sql="delete  from tb_user where id=?";

        try {
            // 创建 PreparedStatement对象
            PreparedStatement ps= conn.prepareStatement(sql);
            //给问号赋值
            ps.setInt(1,Integer.parseInt(id));
            //执行
           row=ps.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  row;
    }

    //根据id查找当前用户
    public User findUserInfo(String id){
        User user=null;
        //获取数据连接
        Connection conn=DBUtil.getConn();
        //编写sql
        String sql="select * from tb_user where id=?";
        //创建PreparedStatement 对象
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            //给问号赋值
            ps.setInt(1,Integer.parseInt(id));
            //执行
            ResultSet r=ps.executeQuery();
            //遍历结果集

            if(r.next()){
                Integer userid= r.getInt("id");
                String name=r.getString("name");
                String pwd=r.getString("password");
                String tel=r.getString("tel");
                //将取出的数据封装到对象
                user=new User();
                user.setId(userid);
                user.setName(name);
                user.setPassword(pwd);
                user.setTel(tel);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  user;
    }

    //根据id执行用户信息的修改
    public int  toUpdateUserInfo(String id,String name,String pwd,String tel){
        //获取连接对象
        Connection conn = DBUtil.getConn();
        int row=0;
        //编写sql
        String sql="update tb_user set password=?,tel=? where id=?";
        //得到PreparedStatement对象
        try {
            PreparedStatement ps= conn.prepareStatement(sql);

            //给问号赋值
            ps.setString(1,pwd);
            ps.setString(2,tel);
            ps.setInt(3,Integer.parseInt(id));
            //执行
           row=ps.executeUpdate();
            //返回受影响行数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  row;
    }


    //添加用户
    public int addUserInfo(User user) {
        //获取数据库的连接对象
        Connection conn = null;
        PreparedStatement ps = null;
        int row = 0;

        try {
            conn = DBUtil.getConn();
            System.out.println("conn:" + conn);
            //创建SQL
            String sql = "insert into tb_user(id,name,password,tel) values(null,?,?,?)";
            ps = conn.prepareStatement(sql);
            //给问号赋值
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getTel());

            //执行
            row = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return row;

    }

    //模糊查询
    public List<User> selectUserForLike(String name){

        List<User> list=new ArrayList<>();
    //获取数据库连接
        Connection conn = DBUtil.getConn();
        //编写sql      like %卢%
        String sql="select * from tb_user where name like '%"+ name+"%'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
           // ps.setString(1,name);
            ResultSet r=ps.executeQuery();
            //遍历结果集
            while(r.next()){
                Integer id= r.getInt("id");
                String username = r.getString("name");
                String password = r.getString("password");
                String tel = r.getString("tel");
                //将数据封装到对象
                User user= new User();
                user.setName(username);
                user.setPassword(password);
                user.setTel(tel);
                user.setId(id);
                //将对象添加到集合中
                list.add(user);

            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  list;
    }


}
