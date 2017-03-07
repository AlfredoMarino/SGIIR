SELECT
     naturaleza.`TipoNaturaleza` AS naturaleza_TipoNaturaleza,
     naturaleza.`PrioridadNaturaleza` AS naturaleza_PrioridadNaturaleza,
     institucion.`NombreInstitucion` AS institucion_NombreInstitucion,
     tarea.`CodigoTarea` AS tarea_CodigoTarea,
     tarea.`DescripcionTarea` AS tarea_DescripcionTarea,
     tarea.`FechaRecepcionTarea` AS tarea_FechaRecepcionTarea,
     tarea.`FechaEstimadaTarea` AS tarea_FechaEstimadaTarea,
     tarea.`FechaFinalizacionTarea` AS tarea_FechaFinalizacionTarea
FROM
     `institucion` institucion INNER JOIN `naturaleza` naturaleza ON institucion.`CodigoInstitucion` = naturaleza.`CodigoInstitucion`
     INNER JOIN `tarea` tarea ON naturaleza.`CodigoNaturaleza` = tarea.`CodigoNaturaleza`
WHERE
     FechaFinalizacionTarea IS NOT null