A logging device (logger) can be installed on a truck, trailer, van, etc (vehicle).
A logger has a unique serial number and records periodic GPS locations as (timestamp, latitude, longitude).
A vehicle has a unique registration number.
If a logger is damaged, it will be removed from the vehicle and a new logger (with a different serial number) fitted. The broken logger will
then be repaired and eventually fitted on a different vehicle.
The logged GPS locations in each logger are periodically downloaded and persisted.
Design a service (REST or otherwise) that allows:
GPS Records in a suitable format to be persisted via the service
Persisted GPS records for a vehicle to be queried regardless of any replacement loggers via the service.


to create database execute execute "docker-compose up" command

to execute project "mvn spring-boot:run"

using GET : http://localhost:8080/service/logs
using GET : http://localhost:8080/service/logs/1
using GET : http://localhost:8080/service/gpslogs/111
using GET : http://localhost:8080/service/gpslogs/222

using POST : http://localhost:8080/service/logs/
{
    "gpsSerialId": 333,
    "latitude": "228222392",
    "longitude": "324311545"
}

Note: In real time GPS Quardinate colum  type will be different

In case DB is not able to connect IP need to change