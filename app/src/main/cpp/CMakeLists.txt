

cmake_minimum_required(VERSION 3.4.1)


set(distribution_DIR ${CMAKE_CURRENT_SOURCE_DIR}/../../../libs)

message("-----------------------a")
message(${distribution_DIR})
message("-----------------------aa")

#add_library(fmod
#        SHARED
#        IMPORTED)
#set_target_properties(fmod
#        PROPERTIES IMPORTED_LOCATION
#        ${distribution_DIR}/${ANDROID_ABI}/libfmod.so)
#
#add_library(fmodL
#        SHARED
#        IMPORTED)
#set_target_properties(fmodL
#        PROPERTIES IMPORTED_LOCATION
#        ${distribution_DIR}/${ANDROID_ABI}/libfmodL.so)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

include_directories(inc)

add_library(
        native-lib

        SHARED
        qq_voice.cpp
        common.cpp
        common_platform.cpp
)


find_library(
        log-lib

        log)

file(GLOB OUTPUT_LIBRARY ${distribution_DIR}/${CMAKE_ANDROID_ARCH_ABI}/*.so) # 找到对应cpu的so库文件

target_link_libraries(
        native-lib
#        fmod
#        fmodL
        ${OUTPUT_LIBRARY}
        ${log-lib})