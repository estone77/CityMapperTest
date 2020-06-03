station "SubwayFordhamRd4" with {
  name "Fordham Rd"
  coords { lat 40.862803; lon -73.901034 }
  static_code { name "cm_station_id"; value "SubwayFordhamRd4" }
  static_code { name "gtfs_id"; value "407" }
  static_code { name "brand_id"; value "NewYorkSubway" }
  static_code { name "route_id"; value "4" }
  static_code { name "route_short_name"; value "4" }
  realtime_code { name "gtfs_id"; value "407" }

  stop "Platform_SubwayFordhamRd4_4_dNE" with {
    name "Fordham Rd"
    layer -1
    static_code { name "gtfs_id"; value "407N" }
    static_code { name "brand_id"; value "NewYorkSubway" }
    static_code { name "route_short_name"; value "4" }
    realtime_code { name "gtfs_id"; value "407N" }
  }
  stop "Platform_SubwayFordhamRd4_4_dSW" with {
    name "Fordham Rd"
    layer -1
    static_code { name "gtfs_id"; value "407S" }
    static_code { name "brand_id"; value "NewYorkSubway" }
    static_code { name "route_short_name"; value "4" }
    realtime_code { name "gtfs_id"; value "407S" }
  }

  platform "Platform_Platform_SubwayFordhamRd4_4_dNE" to stop["Platform_SubwayFordhamRd4_4_dNE"] with {
    long_name "Uptown"
    layer 2
    way {
      way_modifier {
        type WayModifierType.PLATFORM_GAP_HORIZONTAL_MM
        value 77
      }
      way_modifier {
        type WayModifierType.PLATFORM_GAP_VERTICAL_MM
        value 17
      }
    }
  }
  platform "Platform_Platform_SubwayFordhamRd4_4_dSW" to stop["Platform_SubwayFordhamRd4_4_dSW"] with {
    long_name "Manhattan"
    layer 2
    way {
      way_modifier {
        type WayModifierType.PLATFORM_GAP_HORIZONTAL_MM
        value 77
      }
      way_modifier {
        type WayModifierType.PLATFORM_GAP_VERTICAL_MM
        value 17
      }
    }
  }

  exit "SubwayFordhamRd4_E01" with {
    long_name "Jerome Ave & Fordham Rd, SW corner"
    coords { lat 40.862562; lon -73.901367 }
    layer 0
  }
  exit "SubwayFordhamRd4_E02" with {
    long_name "Jerome Ave & Fordham Rd, SE corner"
    coords { lat 40.862592; lon -73.90097 }
    layer 0
  }
  exit "SubwayFordhamRd4_E03" with {
    long_name "Jerome Ave & Fordham Rd, NW corner"
    coords { lat 40.86289; lon -73.901262 }
    layer 0
  }
  exit "SubwayFordhamRd4_E04" with {
    long_name "Jerome Ave & Fordham Rd, NE corner"
    coords { lat 40.862814; lon -73.900815 }
    layer 0
  }





  from platform["Platform_Platform_SubwayFordhamRd4_4_dNE"] to platform["Platform_Platform_SubwayFordhamRd4_4_dSW"] add {
    kind WayKind.WALKWAY
    average_duration_seconds 60
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dNE"] to exit["SubwayFordhamRd4_E01"] add {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dNE"] to exit["SubwayFordhamRd4_E02"] add {
    kind WayKind.ELEVATOR
    average_duration_seconds 270
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dNE"] to exit["SubwayFordhamRd4_E02"] add {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dNE"] to exit["SubwayFordhamRd4_E03"] add {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dNE"] to exit["SubwayFordhamRd4_E04"] add {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dSW"] to platform["Platform_Platform_SubwayFordhamRd4_4_dNE"] add {
    kind WayKind.WALKWAY
    average_duration_seconds 60
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dSW"] to exit["SubwayFordhamRd4_E01"] add {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dSW"] to exit["SubwayFordhamRd4_E02"] add {
    kind WayKind.ELEVATOR
    average_duration_seconds 270
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dSW"] to exit["SubwayFordhamRd4_E02"] add {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dSW"] to exit["SubwayFordhamRd4_E03"] add {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }

  from platform["Platform_Platform_SubwayFordhamRd4_4_dSW"] to exit["SubwayFordhamRd4_E04"] add {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
    start_node_location_hint { structured_hint LocationHintStructuredHint.PLATFORM_MIDDLE }
  }

  from exit["SubwayFordhamRd4_E02"] to platform["Platform_Platform_SubwayFordhamRd4_4_dNE"] add {
    kind WayKind.ELEVATOR
    average_duration_seconds 270
  }

  from exit["SubwayFordhamRd4_E02"] to platform["Platform_Platform_SubwayFordhamRd4_4_dSW"] add {
    kind WayKind.ELEVATOR
    average_duration_seconds 270
  }


  between platforms[] and exits[] addDefault {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 90
  }


  between platforms[] and platforms[] addDefault {
    kind WayKind.UNKNOWN_NOT_STEP_FREE
    average_duration_seconds 60
  }

}
