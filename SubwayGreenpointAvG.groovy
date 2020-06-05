station "SubwayGreenpointAv" with {
  name "Greenpoint Av"
  coords { lat 40.731352; lon -73.954449 }
  static_code { name "cm_station_id"; value "SubwayGreenpointAv" }
  static_code { name "brand_id"; value "NewYorkSubway" }
  static_code { name "gtfs_id"; value "G26" }
  static_code { name "route_id"; value "G" }
  static_code { name "route_short_name"; value "G" }
  realtime_code { name "gtfs_id"; value "G26" }
//North bound Stop
  stop "Platform_SubwayGreenpointAv_G_dN" with {
    name "Greenpoint Av"
    layer -1
    static_code { name "brand_id"; value "NewYorkSubway" }
    static_code { name "gtfs_id"; value "G26N" }
    static_code { name "route_short_name"; value "G" }
    realtime_code { name "gtfs_id"; value "G26N" }
  }
//South bound Stop
  stop "Platform_SubwayGreenpointAv_G_dS" with {
    name "Greenpoint Av"
    layer -1
    static_code { name "brand_id"; value "NewYorkSubway" }
    static_code { name "gtfs_id"; value "G26S" }
    static_code { name "route_short_name"; value "G" }
    realtime_code { name "gtfs_id"; value "G26S" }
  }
//North Platform connect to North Stop
  platform "Platform_Platform_SubwayGreenpointAv_G_dN" to stop["Platform_SubwayGreenpointAv_G_dN"] with {
    long_name "Court Sq"
    layer -2
     way {
      way_modifier {
        type WayModifierType.PLATFORM_GAP_HORIZONTAL_MM
        value 85
      }
      way_modifier {
        type WayModifierType.PLATFORM_GAP_VERTICAL_MM
        value 50
      }
    }
  }
//South Platform connect to South Stop
  platform "Platform_Platform_SubwayGreenpointAv_G_dS" to stop["Platform_SubwayGreenpointAv_G_dS"] with {
    long_name "Church Av"
    layer -2
     way {
      way_modifier {
        type WayModifierType.PLATFORM_GAP_HORIZONTAL_MM
        value 85
      }
      way_modifier {
        type WayModifierType.PLATFORM_GAP_VERTICAL_MM
        value 50
      }
    }
  }

//direction: E, Exit 1 SW corner Greenpoint Ave
  exit "SubwayGreenpointAv_E01" with {
    long_name "Manhattan Ave & Greenpoint Ave, SW corner"
    coords { lat 40.73007; lon -73.954377 }
    layer 0
  }
//direction: W, Exit 2 SE corner Greenpoint Ave
  exit "SubwayGreenpointAv_E02" with {
    long_name "Manhattan Ave & Greenpoint Ave, SE corner"
    coords { lat 40.730122; lon -73.954049 }
    layer 0
  }
//direction: W, Exit 3 NW corner Greenpoint Ave
  exit "SubwayGreenpointAv_E03" with {
    long_name "Manhattan Ave & Greenpoint Ave, NW corner"
    coords { lat 40.730278; lon -73.954488 }
    layer 0
  }
//direction: W, Exit 4 SE corner India St
  exit "SubwayGreenpointAv_E04" with {
    long_name "Manhattan Ave & India St, SE corner"
    coords { lat 40.732258; lon -73.954379 }
    layer 0
  }
//direction: E, Exit 5 SW corner India St
  exit "SubwayGreenpointAv_E05" with {
    long_name "Manhattan Ave & India St, SW corner"
    coords { lat 40.732216; lon -73.954784 }
    layer 0
  }
  //ELEVATOR BEING BUILT! WILL INCLUDE NEW TURNSTILE. Entrance on NE corner of Manhattan Ave and Greenpoint
  //direction: S
//   exit "SubwayGreenpointAv_E06" with  {
//     long_name "Manhattan Ave & Greenpoint Ave, NE corner"
//     coords { lat 40.730411; lon -73.954245 }
//     layer 0
//   }
//Turnstile 1 Main
  facility "GreenpointAve_turnstile" with {
    kind FacilityKind.TICKET_GATE
    layer -1
  }
//Turnstile 2 India SE
  facility "ManhattanAve_SE_turnstile" with {
    kind FacilityKind.TICKET_GATE
    layer -2
  }
//Turnstile 3 India SW
  facility "ManhattanAve_SW_turnstile" with {
    kind FacilityKind.TICKET_GATE
    layer -2
  }
//   //Elevator turnstile
//   facility "ManhattanAve_NE_turnstile" with {
//     kind FacilityKind.TICKET_GATE
//     layer -1
//   }

//The following connect turnstiles to Exits
  between facility["GreenpointAve_turnstile"] and exit["SubwayGreenpointAv_E01"] add {
    kind WayKind.STAIRS
    average_duration_seconds 60
  }

  between facility["GreenpointAve_turnstile"] and exit["SubwayGreenpointAv_E02"] add {
    kind WayKind.STAIRS
    average_duration_seconds 60
  }

  between facility["GreenpointAve_turnstile"] and exit["SubwayGreenpointAv_E03"] add {
    kind WayKind.STAIRS
    average_duration_seconds 60
  }

  between facility["ManhattanAve_SE_turnstile"] and exit["SubwayGreenpointAv_E04"] add {
    kind WayKind.STAIRS
    average_duration_seconds 60
  }

  between facility["ManhattanAve_SW_turnstile"] and exit["SubwayGreenpointAv_E05"] add {
    kind WayKind.STAIRS
    average_duration_seconds 60
  }
//this is elevator
//   between facility["ManhattanAve_NE_turnstile"] and exit["SubwayGreenpointAv_E06"] add {
//     kind WayKind.ELEVATOR
//     average_duration_seconds 60
//   }

//Connect South Platform - North Platform
  from platform["Platform_Platform_SubwayGreenpointAv_G_dS"] to platform["Platform_Platform_SubwayGreenpointAv_G_dN"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_FRONT }
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }
//Connect North Platform - South Platform
  from platform["Platform_Platform_SubwayGreenpointAv_G_dN"] to platform["Platform_Platform_SubwayGreenpointAv_G_dS"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_BACK }
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }
//Connect Turnstile 1 - South Platform
  from facility["GreenpointAve_turnstile"] to platform["Platform_Platform_SubwayGreenpointAv_G_dS"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
  }
//Connect South Platform - Turnstile 1
  from platform["Platform_Platform_SubwayGreenpointAv_G_dS"] to facility["GreenpointAve_turnstile"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_FRONT }
  }
//Connect Turnstile 1 - North Platform
 from facility["GreenpointAve_turnstile"] to platform["Platform_Platform_SubwayGreenpointAv_G_dN"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
  }
//Connect North Platform - Turnstile 1
 from platform["Platform_Platform_SubwayGreenpointAv_G_dN"] to facility["GreenpointAve_turnstile"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_BACK }
  }
//Connect Turnstile 2 - North Platform // Single connection
 from facility["ManhattanAve_SE_turnstile"] to platform["Platform_Platform_SubwayGreenpointAv_G_dN"] add {
    kind WayKind.STAIRS
   way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
 }
//Connect North Platform - Turnstile 2 // Single connection
 from platform["Platform_Platform_SubwayGreenpointAv_G_dN"] to facility["ManhattanAve_SE_turnstile"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_FRONT }
  }
//Connect Turnstile 3 - South Platform // Single conncetion
 from facility["ManhattanAve_SW_turnstile"] to platform["Platform_Platform_SubwayGreenpointAv_G_dS"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
  }
//Connect South Platform - Turnstile 3 // Single connection
 from platform["Platform_Platform_SubwayGreenpointAv_G_dS"] to facility["ManhattanAve_SW_turnstile"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_BACK }
  }

//BELOW IS ELEVATOR INFO!!!!!!!!!!
//  from facility["ManhattanAve_NE_turnstile"] to platform["Platform_Platform_SubwayGreenpointAv_G_dS"] add {
//     kind WayKind.STAIRS
//     way_modifier { type WayModifierType.STEPS; value 18 }
//     average_duration_seconds 150
//     start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_BACK }
//     start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
//   }
//  from platform["Platform_Platform_SubwayGreenpointAv_G_dS"] to facility["ManhattanAve_NE_turnstile"] add {
//     kind WayKind.STAIRS
//     average_duration_seconds 120
//   }
//  from facility["ManhattanAve_NE_turnstile"] to platform["Platform_Platform_SubwayGreenpointAv_G_dN"] add {
//     kind WayKind.STAIRS
//     way_modifier { type WayModifierType.STEPS; value 18 }
//     average_duration_seconds 150
//     start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_BACK }
//     start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
//   }
//  from platform["Platform_Platform_SubwayGreenpointAv_G_dN"] to facility["ManhattanAve_NE_turnstile"] add {
//     kind WayKind.STAIRS
//     average_duration_seconds 120
//   }
}
