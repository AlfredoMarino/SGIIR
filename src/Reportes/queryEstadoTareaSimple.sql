SELECT
     bitacora.`CodigoNaturaleza` AS bitacora_CodigoNaturaleza,
     bitacora.`CodigoTarea` AS bitacora_CodigoTarea,
     bitacora.`CorrelativoBitacora` AS bitacora_CorrelativoBitacora,
     bitacora.`ObservacionBitacora` AS bitacora_ObservacionBitacora,
     bitacora.`FechaBitacora` AS bitacora_FechaBitacora,
     bitacora.`HoraBitacora` AS bitacora_HoraBitacora,
     estado.`DescripcionEstado` AS estado_DescripcionEstado,
     institucion.`CodigoInstitucion` AS institucion_CodigoInstitucion,
     institucion.`NombreInstitucion` AS institucion_NombreInstitucion,
     naturaleza.`CodigoInstitucion` AS naturaleza_CodigoInstitucion,
     naturaleza.`TipoNaturaleza` AS naturaleza_TipoNaturaleza,
     naturaleza.`PrioridadNaturaleza` AS naturaleza_PrioridadNaturaleza,
     naturaleza.`CodigoNaturaleza` AS naturaleza_CodigoNaturaleza,
     tarea.`CodigoNaturaleza` AS tarea_CodigoNaturaleza,
     tarea.`CodigoTarea` AS tarea_CodigoTarea,
     tarea.`DescripcionTarea` AS tarea_DescripcionTarea,
     tarea.`FechaRecepcionTarea` AS tarea_FechaRecepcionTarea,
     tarea.`HoraEstimadaTarea` AS tarea_HoraEstimadaTarea,
     tarea.`ObservacionTarea` AS tarea_ObservacionTarea,
     tarea.`FechaFinalizacionTarea` AS tarea_FechaFinalizacionTarea,
     tarea.`HoraFinalizacionTarea` AS tarea_HoraFinalizacionTarea,
     tarea.`HoraRecepcionTarea` AS tarea_HoraRecepcionTarea,
     tarea.`FechaEstimadaTarea` AS tarea_FechaEstimadaTarea
FROM
     `estado` estado INNER JOIN `bitacora` bitacora ON estado.`CodigoEstado` = bitacora.`CodigoEstado`
     LEFT OUTER JOIN `tarea` tarea ON bitacora.`CodigoTarea` = tarea.`CodigoTarea`
     AND bitacora.`CodigoNaturaleza` = tarea.`CodigoNaturaleza`
     INNER JOIN `naturaleza` naturaleza ON tarea.`CodigoNaturaleza` = naturaleza.`CodigoNaturaleza`
     INNER JOIN `institucion` institucion ON naturaleza.`CodigoInstitucion` = institucion.`CodigoInstitucion`
ORDER BY
     bitacora.CodigoNaturaleza ASC,
     bitacora.CodigoTarea ASC,
     bitacora.CorrelativoBitacora ASC