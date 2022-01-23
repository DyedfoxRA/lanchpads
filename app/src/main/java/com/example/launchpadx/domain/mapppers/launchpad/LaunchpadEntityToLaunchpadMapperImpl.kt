package com.example.launchpadx.domain.mapppers.launchpad

import com.example.launchpadx.data.entity.LaunchpadEntity
import com.example.launchpadx.domain.mapppers.location.LocationEntityToLocationMapper
import com.example.launchpadx.domain.model.Launchpad

class LaunchpadEntityToLaunchpadMapperImpl(
    private val locationEntityToLocationMapper: LocationEntityToLocationMapper
) : LaunchpadEntityToLaunchpadMapper {

    override fun map(raw: LaunchpadEntity): Launchpad {
        return Launchpad(
            raw.attemptedLaunches,
            raw.details,
            raw.id,
            locationEntityToLocationMapper.map(raw.locationEntity),
            raw.name,
            raw.siteId,
            raw.siteNameLong,
            raw.status,
            raw.successfulLaunches,
            raw.vehiclesLaunched,
            raw.wikipedia
        )
    }

    override fun mapList(raw: List<LaunchpadEntity>): List<Launchpad> {
        return raw.map(::map)
    }
}
