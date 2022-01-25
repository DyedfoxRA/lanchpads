package com.example.launchpadx.domain.mapppers.location

import com.example.launchpadx.data.entity.LocationEntity
import com.example.launchpadx.domain.model.Location

class LocationEntityToLocationMapperImpl : LocationEntityToLocationMapper {

    override fun map(raw: LocationEntity): Location {
        return Location(raw.latitude, raw.longitude, raw.name, raw.region)
    }
}
