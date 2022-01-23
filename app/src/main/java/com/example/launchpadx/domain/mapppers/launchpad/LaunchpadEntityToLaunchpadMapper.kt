package com.example.launchpadx.domain.mapppers.launchpad

import com.example.launchpadx.data.entity.LaunchpadEntity
import com.example.launchpadx.domain.mapppers.ListMapper
import com.example.launchpadx.domain.model.Launchpad

interface LaunchpadEntityToLaunchpadMapper : ListMapper<LaunchpadEntity, Launchpad>
