package com.impldao;
import com.Dao;
import com.l8.DataBase;
import com.obj.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDao implements Dao<City> {
    Connection c = DataBase.getConnection();
    List<City> listCity;

    public CityDao(Connection c) {
        this.c = c;
        listCity = new ArrayList<>();
    }
    public void loadAll()
    {
        Statement stmt = null;
        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM city;" );

            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int code  = rs.getInt("code");
                String  continent = rs.getString("code");
               listCity.add(new City(id,name,code,continent));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<City> get(long id) {
        PreparedStatement stmt = null;
        String sql = "SELECT * from city where id = ?";
        Optional<City> ret1 = null;
        try {
            stmt = c.prepareStatement(sql);
            stmt.setInt(1, (int) id);

            ResultSet rs1 = stmt.executeQuery();
            while (rs1.next()) {
                int idRs1 = rs1.getInt(1);
                String nameRs1 = rs1.getString(2);
                int codeRs1 = rs1.getInt(3);
                String addresRs1 = rs1.getString(4);
                City ret = new City(idRs1, nameRs1, codeRs1, addresRs1);
                ret1 = Optional.ofNullable(ret);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Optional<City> ret11 = (Optional<City>) Optional.ofNullable(ret1);
        return ret11;
    }

    @Override
    public List<City> getAll() {
        return listCity;
    }

    @Override
    public void save(City city) {

    }

    @Override
    public void update(City city, String[] params) {

    }

    @Override
    public void delete(City city) {

    }
}
