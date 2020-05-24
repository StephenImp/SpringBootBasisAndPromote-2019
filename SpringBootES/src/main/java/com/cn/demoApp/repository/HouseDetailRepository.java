package com.cn.demoApp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cn.demoApp.entity.HouseDetail;

/**
 * Created by 瓦力.
 */
public interface HouseDetailRepository extends CrudRepository<HouseDetail, Long>{
    HouseDetail findByHouseId(Long houseId);

    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}
