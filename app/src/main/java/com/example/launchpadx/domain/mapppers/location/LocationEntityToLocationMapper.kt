package com.example.launchpadx.domain.mapppers.location

import com.example.launchpadx.data.entity.LocationEntity
import com.example.launchpadx.domain.mapppers.Mapper
import com.example.launchpadx.domain.model.Location

interface LocationEntityToLocationMapper : Mapper<LocationEntity, Location>
