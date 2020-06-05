station "SubwayBroadwayG" with {
  name "Broadway"
  coords { lat 40.706092; lon -73.950308 }
  static_code { name "cm_station_id"; value "SubwayBroadwayG" }
  static_code { name "brand_id"; value "NewYorkSubway" }
  static_code { name "gtfs_id"; value "G30" }
  static_code { name "route_id"; value "G" }
  static_code { name "route_short_name"; value "G" }
  realtime_code { name "gtfs_id"; value "G30" }

//North Stop Platform
  stop "Platform_SubwayBroadwayG_G_dN" with {
    name "Broadway"
    layer -1
    static_code { name "brand_id"; value "NewYorkSubway" }
    static_code { name "gtfs_id"; value "G30N" }
    static_code { name "route_short_name"; value "G" }
    realtime_code { name "gtfs_id"; value "G30N" }
  }
 //South Stop Platform
  stop "Platform_SubwayBroadwayG_G_dS" with {
    name "Broadway"
    layer -1
    static_code { name "brand_id"; value "NewYorkSubway" }
    static_code { name "gtfs_id"; value "G30S" }
    static_code { name "route_short_name"; value "G" }
    realtime_code { name "gtfs_id"; value "G30S" }
  }
//North Platform connect to North Stop
  platform "Platform_Platform_SubwayBroadwayG_G_dN" to stop["Platform_SubwayBroadwayG_G_dN"] with {
    long_name "Queens"
    layer -2
  }
 //South Platform connect to South Stop
  platform "Platform_Platform_SubwayBroadwayG_G_dS" to stop["Platform_SubwayBroadwayG_G_dS"] with {
    long_name "Church Av"
    layer -2
  }
//Exit 1 at Broadway and Heyward
  exit "SubwayBroadwayG_E01" with {
    long_name "Broadway & Heyward Street"
    coords { lat 40.70549; lon -73.950554 }
    layer 0
  }
 //Exit 2 on NE corner, Union and Broadway
  exit "SubwayBroadwayG_E02" with {
    long_name "Union Ave & Broadway, NE corner"
    coords { lat 40.705495; lon -73.950089 }
    layer 0
  }
 //Exit 3 on SW corner, Union and Broadway
  exit "SubwayBroadwayG_E03" with {
    long_name "Union Ave & Broadway, SW corner"
    coords { lat 40.705204; lon -73.95032 }
    layer 0
  }
//Turnstile
  facility "Broadway_turnstile" with {
    kind FacilityKind.TICKET_GATE
    layer -1
  }
//Connect Exit 1 - Turnstile
  between facility["Broadway_turnstile"] and exit["SubwayBroadwayG_E01"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 40 }
    average_duration_seconds 90
  }
 //Connect Exit 2 - Turnstile
  between facility["Broadway_turnstile"] and exit["SubwayBroadwayG_E02"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 40 }
    average_duration_seconds 90
  }
 //Connect Exit 3 - Turnstile
  between facility["Broadway_turnstile"] and exit["SubwayBroadwayG_E03"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 40 }
    average_duration_seconds 90
  }
//Connect South Platform - North Platform using stairs
  from platform["Platform_Platform_SubwayBroadwayG_G_dS"] to platform["Platform_Platform_SubwayBroadwayG_G_dN"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_FRONT }
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }
 //Connect North Platform - South Platform using stairs
  from platform["Platform_Platform_SubwayBroadwayG_G_dN"] to platform["Platform_Platform_SubwayBroadwayG_G_dS"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_BACK }
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }
//Connect South Platform - Turnstile
  from platform["Platform_Platform_SubwayBroadwayG_G_dS"] to facility["Broadway_turnstile"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_FRONT }
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }
//Connect Turnstile - South Platform
  from facility["Broadway_turnstile"] to platform["Platform_Platform_SubwayBroadwayG_G_dS"] add {
    kind WayKind.STAIRS
    average_duration_seconds 150
  }
//Connect North Platform - Turnstile
  from platform["Platform_Platform_SubwayBroadwayG_G_dN"] to facility["Broadway_turnstile"] add {
    kind WayKind.STAIRS
    way_modifier { type WayModifierType.STEPS; value 18 }
    average_duration_seconds 150
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_BACK }
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }
//Connect Turnstile - North Platform
  from facility["Broadway_turnstile"] to platform["Platform_Platform_SubwayBroadwayG_G_dN"] add {
    kind WayKind.STAIRS
    average_duration_seconds 150
  }
}
